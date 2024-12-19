package rainbowfriends.daramserverdev.domain.auth.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.global.security.key.repository.KeyRepository

@Component
class FindKey(private val keyRepository: KeyRepository) {
    fun findKey(key: String): Boolean {
        return keyRepository.existsByKey(key)
    }
}