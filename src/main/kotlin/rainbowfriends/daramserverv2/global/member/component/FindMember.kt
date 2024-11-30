package rainbowfriends.daramserverv2.global.member.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverv2.global.member.entity.Member
import rainbowfriends.daramserverv2.global.member.repository.MemberRepository

@Component
class FindMember(private val memberRepository: MemberRepository) {
    fun findMemberByEmail(email: String): Member? {
        return memberRepository.findByEmail(email)
    }

    fun findMemberByGradeAndClassNumAndNumber(grade: Int, classNum: Int, number: Int): Member? {
        return memberRepository.findByGradeAndClassNumAndNumber(grade, classNum, number)
    }
}