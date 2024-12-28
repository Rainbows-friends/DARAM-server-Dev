package rainbowfriends.daramserverdev.global.member.dto

import rainbowfriends.daramserverdev.global.member.entity.Member
import rainbowfriends.daramserverdev.global.member.enums.Roles

data class MemberDTO(
    val id: Long? = 0,
    var email: String? = null,
    var name: String,
    var grade: Int,
    var classNum: Int,
    var number: Int,
    var floor: Int,
    var room: Int,
    var role: Roles,
    var stay: Boolean = true,
    var lateNumber: Long = 0
) {
    fun toEntity(): Member {
        return Member(
            id = id,
            email = email,
            name = name,
            grade = grade,
            classNum = classNum,
            number = number,
            floor = floor,
            room = room,
            role = role,
            stay = stay,
            lateNumber = lateNumber
        )
    }
}