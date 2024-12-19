package rainbowfriends.daramserverdev.domain.notice.service

import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse

interface GetNoticeService {
    fun getNotice(id: Long): NoticeResponse
}