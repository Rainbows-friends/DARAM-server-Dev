package rainbowfriends.daramserverdev.domain.notice.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse
import rainbowfriends.daramserverdev.domain.notice.exception.NoticeNotFoundException
import rainbowfriends.daramserverdev.domain.notice.repository.NoticeRepository

@Component
class FindNotice(private val noticeRepository: NoticeRepository) {
    fun findNotice(id: Long): NoticeResponse {
        val notice = noticeRepository.findById(id).orElseThrow {
            NoticeNotFoundException("Notice Not Found")
        }
        return NoticeResponse(
            id = notice.id,
            title = notice.title,
            context = notice.context,
            author = notice.author,
            createdAt = notice.createdAt
        )
    }

    fun findNotice(): List<NoticeResponse> {
        val notices = noticeRepository.findAll()
        if (notices.isEmpty()) {
            throw NoticeNotFoundException("Notice Not Found")
        }
        return notices.map {
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