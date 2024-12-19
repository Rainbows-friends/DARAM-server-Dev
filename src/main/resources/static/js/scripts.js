document.addEventListener('DOMContentLoaded', function () {
    const serverTimeElement = document.getElementById('server-time');
    let serverTime = new Date(serverTimeElement.textContent);
    const updateInterval = 1000;
    const syncInterval = 60000;
    const formatServerTime = (time) => {
        const year = time.getFullYear();
        const month = String(time.getMonth() + 1).padStart(2, '0');
        const date = String(time.getDate()).padStart(2, '0');
        const hours = String(time.getHours()).padStart(2, '0');
        const minutes = String(time.getMinutes()).padStart(2, '0');
        const seconds = String(time.getSeconds()).padStart(2, '0');
        return `${year}-${month}-${date} ${hours}:${minutes}:${seconds}`;
    };
    const updateTime = () => {
        serverTime = new Date(serverTime.getTime() + updateInterval);
        serverTimeElement.textContent = formatServerTime(serverTime);
    };
    const syncWithServer = async () => {
        try {
            const response = await fetch('/get-server-time');
            if (response.ok) {
                const newTime = await response.text();
                serverTime = new Date(newTime);
            }
        } catch (error) {
            console.error('Error while syncing time:', error);
        }
    };
    const intervalId = setInterval(updateTime, updateInterval);
    setTimeout(() => {
        clearInterval(intervalId);
        syncWithServer();
        setInterval(updateTime, updateInterval);
    }, syncInterval);
});