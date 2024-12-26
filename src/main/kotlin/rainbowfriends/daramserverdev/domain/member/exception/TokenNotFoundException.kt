package rainbowfriends.daramserverdev.domain.member.exception

class TokenNotFoundException : RuntimeException {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}