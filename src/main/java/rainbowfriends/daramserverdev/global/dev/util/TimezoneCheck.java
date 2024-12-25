package rainbowfriends.daramserverdev.global.dev.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimezoneCheck implements DisposableBean {
    private static final Logger log = LoggerFactory.getLogger(TimezoneCheck.class);

    @EventListener(ApplicationReadyEvent.class)
    public void checkTimezone() {
        log.info("Current Timezone: {}", java.util.TimeZone.getDefault().getID());
        LocalDateTime now = LocalDateTime.now();
        log.info("Current Time: {}", now);
        log.info("TimezoneCheck is shutting down after initialization...");
    }

    @Override
    public void destroy() {
        log.info("TimezoneCheck Bean has been destroyed.");
    }
}