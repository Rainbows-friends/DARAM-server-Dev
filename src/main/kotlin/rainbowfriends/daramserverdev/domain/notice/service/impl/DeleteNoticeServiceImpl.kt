package rainbowfriends.daramserverdev.domain.notice.service.impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.notice.component.DeleteNotice
import rainbowfriends.daramserverdev.domain.notice.service.DeleteNoticeService

@Service
class DeleteNoticeServiceImpl(private val deleteNotice: DeleteNotice) : DeleteNoticeService {
    override fun deleteNotice(id: Long) {
        deleteNotice.deleteNotice(id)
    }
}