package rainbowfriends.daramserverdev.domain.notice.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.domain.notice.dto.request.PostNoticeRequest
import rainbowfriends.daramserverdev.domain.notice.dto.response.NoticeResponse
import rainbowfriends.daramserverdev.domain.notice.entity.Notice
import rainbowfriends.daramserverdev.domain.notice.exception.DuplicateNoticeException
import rainbowfriends.daramserverdev.domain.notice.repository.NoticeRepository
import rainbowfriends.daramserverdev.global.member.enums.Roles
import java.time.LocalDateTime

@Component
class SaveNotice(private val noticeRepository: NoticeRepository) {
    fun saveNotice(request: PostNoticeRequest, role: Roles): NoticeResponse {
        val notice = Notice(
            id = null,
            title = request.title,
            context = request.content,
            author = role,
            createdAt = LocalDateTime.now()
        )
        noticeRepository.findByTitle(request.title)?.let {
            if (it.author == role && it.context == request.content) {
                throw DuplicateNoticeException("notice already exists")
            }
        }
        return noticeRepository.save(notice).let {
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