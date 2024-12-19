package rainbowfriends.daramserverdev.global.security.key.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rainbowfriends.daramserverdev.global.security.key.entity.Key

@Deprecated("Use JwtTokenRefreshService instead")
@Repository
interface KeyRepository : JpaRepository<Key, String> {
    fun existsByKey(key: String): Boolean
    fun findByKey(key: String): Key
}