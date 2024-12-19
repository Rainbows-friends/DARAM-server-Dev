package rainbowfriends.daramserverdev.domain.notice.service

import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse

interface GetAllNoticeService {
    fun getAllNotices(): List<NoticeResponse>
}