package rainbowfriends.daramserverdev.domain.notice.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.domain.notice.exception.NoticeNotFoundException
import rainbowfriends.daramserverdev.domain.notice.repository.NoticeRepository

@Component
class DeleteNotice(private val noticeRepository: NoticeRepository) {
    fun deleteNotice(id: Long) {
        if (!noticeRepository.existsById(id)) {
            throw NoticeNotFoundException("Notice with ID $id not found")
        }
        noticeRepository.deleteById(id)
    }
}