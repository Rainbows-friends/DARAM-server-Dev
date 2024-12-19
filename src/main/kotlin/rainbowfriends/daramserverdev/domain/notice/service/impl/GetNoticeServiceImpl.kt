package rainbowfriends.daramserverdev.domain.notice.service.impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.notice.component.FindNotice
import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse
import rainbowfriends.daramserverdev.domain.notice.service.GetNoticeService

@Service
class GetNoticeServiceImpl(private val findNotice: FindNotice) : GetNoticeService {
    override fun getNotice(id: Long): NoticeResponse = findNotice.findNotice(id)
}