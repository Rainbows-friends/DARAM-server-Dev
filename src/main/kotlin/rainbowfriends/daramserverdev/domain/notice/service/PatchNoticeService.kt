package rainbowfriends.daramserverdev.domain.notice.service

import rainbowfriends.daramserverdev.domain.notice.dto.request.PatchNoticeRequest
import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse

interface PatchNoticeService {
    fun patchNotice(id: Long, request: PatchNoticeRequest): NoticeResponse
}