package rainbowfriends.daramserverdev.domain.notice.service.impl

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.notice.component.SaveNotice
import rainbowfriends.daramserverdev.domain.notice.dto.request.PostNoticeRequest
import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse
import rainbowfriends.daramserverdev.domain.notice.service.PostNoticeService
import rainbowfriends.daramserverdev.global.security.jwt.service.impl.JwtTokenParserServiceImpl

@Service
class PostNoticeServiceImpl(
    private val jwtTokenParserServiceImpl: JwtTokenParserServiceImpl,
    private val saveNotice: SaveNotice
) :
    PostNoticeService {
    override fun postNotice(request: HttpServletRequest, requestDto: PostNoticeRequest): NoticeResponse {
        val role = jwtTokenParserServiceImpl.extractRole(request.getHeader("Authorization").substringAfter("Bearer "))
        return saveNotice.saveNotice(requestDto, role)
    }
}