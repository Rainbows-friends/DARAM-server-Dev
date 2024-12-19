package rainbowfriends.daramserverdev.domain.notice.service

import jakarta.servlet.http.HttpServletRequest
import rainbowfriends.daramserverdev.domain.notice.dto.request.PostNoticeRequest
import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse

interface PostNoticeService {
    fun postNotice(request: HttpServletRequest, requestDto: PostNoticeRequest): NoticeResponse
}