package rainbowfriends.daramserverdev.domain.auth.service

import rainbowfriends.daramserverdev.domain.auth.dto.response.SigninOrReissueResponse

interface ReissueService {
    fun reissue(refreshToken: String): SigninOrReissueResponse
}