package rainbowfriends.daramserverdev.domain.notice.service.impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.notice.component.FindNotice
import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse
import rainbowfriends.daramserverdev.domain.notice.service.GetAllNoticeService

@Service
class GetAllNoticeServiceImpl(private val findNotice: FindNotice) : GetAllNoticeService {
    override fun getAllNotices(): List<NoticeResponse> {
        val allNotice: List<NoticeResponse> = findNotice.findNotice()
        return allNotice.map {
            NoticeResponse(
                id = it.id,
                title = it.title,
                context = it.context,
                author = it.author,
                createdAt = it.createdAt
            )
        }
    }
}