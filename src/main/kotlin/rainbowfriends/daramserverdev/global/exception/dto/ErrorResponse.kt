package rainbowfriends.daramserverdev.global.exception.dto

import rainbowfriends.daramserverdev.global.exception.dto.enums.ErrorStatus

data class ErrorResponse(
    val status: ErrorStatus,
    val message: String,
    val code: Int
)