package rainbowfriends.daramserverv2.domain.notice.service.impl

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service
import rainbowfriends.daramserverv2.domain.notice.component.SaveNotice
import rainbowfriends.daramserverv2.domain.notice.dto.request.CreateOrUpdateNoticeRequest
import rainbowfriends.daramserverv2.domain.notice.entity.Notice
import rainbowfriends.daramserverv2.domain.notice.service.PostNoticeService
import rainbowfriends.daramserverv2.global.security.token.TokenService

@Service
class PostNoticeServiceImpl(private val tokenService: TokenService, private val saveNotice: SaveNotice) :
    PostNoticeService {
    override fun postNotice(request: HttpServletRequest, requestDto: CreateOrUpdateNoticeRequest): Notice {
        val role = tokenService.decodeToken(tokenService.resolveToken(request.getHeader("Authorization")))
        return saveNotice.saveNotice(requestDto, role)
    }
}