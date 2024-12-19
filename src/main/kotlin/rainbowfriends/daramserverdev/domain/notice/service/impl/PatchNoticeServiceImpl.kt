package rainbowfriends.daramserverdev.domain.notice.service.impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.notice.component.ModifyNotice
import rainbowfriends.daramserverdev.domain.notice.dto.request.PatchNoticeRequest
import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse
import rainbowfriends.daramserverdev.domain.notice.exception.PatchNoticeRequestException
import rainbowfriends.daramserverdev.domain.notice.service.PatchNoticeService
import rainbowfriends.daramserverdev.global.member.enums.Roles

@Service
class PatchNoticeServiceImpl(private val modifyNotice: ModifyNotice) : PatchNoticeService {
    override fun patchNotice(id: Long, request: PatchNoticeRequest): NoticeResponse {
        if (request.author == Roles.USER) {
            throw PatchNoticeRequestException("User cannot modify notice")
        }
        if (request.title == null && request.content == null && request.author == null) {
            throw PatchNoticeRequestException("At least one field should be modified")
        }
        return modifyNotice.modifyNotice(id, request)
    }
}