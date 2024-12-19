package rainbowfriends.daramserverdev.domain.auth.service

import rainbowfriends.daramserverdev.domain.auth.dto.response.SigninOrReissueResponse

interface CameraAuthorizationService {
    fun cameraAuthorization(key: String): SigninOrReissueResponse
}