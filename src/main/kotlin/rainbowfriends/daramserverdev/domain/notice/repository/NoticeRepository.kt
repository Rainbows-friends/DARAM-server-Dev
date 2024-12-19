package rainbowfriends.daramserverdev.domain.notice.repository

import org.springframework.data.jpa.repository.JpaRepository
import rainbowfriends.daramserverdev.domain.notice.entity.Notice

interface NoticeRepository : JpaRepository<Notice, Long> {
    fun findByTitle(title: String): Notice?
}