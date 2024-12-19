package rainbowfriends.daramserverdev.domain.notice.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.domain.notice.dto.request.PatchNoticeRequest
import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse
import rainbowfriends.daramserverdev.domain.notice.exception.NoticeNotFoundException
import rainbowfriends.daramserverdev.domain.notice.repository.NoticeRepository

@Component
class ModifyNotice(
    private val noticeRepository: NoticeRepository
) {
    fun modifyNotice(id: Long, request: PatchNoticeRequest): NoticeResponse {
        val notice = noticeRepository.findById(id).orElseThrow {
            throw NoticeNotFoundException("Notice Not Found")
        }
        request.title?.let { notice.title = it }
        request.content?.let { notice.context = it }
        request.author?.let { notice.author = it }
        noticeRepository.save(notice)
        return NoticeResponse(
            id = notice.id,
            title = notice.title,
            context = notice.context,
            author = notice.author,
            createdAt = notice.createdAt
        )
    }
}