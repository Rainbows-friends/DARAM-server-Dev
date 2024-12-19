package rainbowfriends.daramserverdev.global.member.component

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import rainbowfriends.daramserverdev.global.member.entity.Member
import rainbowfriends.daramserverdev.global.member.repository.MemberRepository

@Component
@Transactional(readOnly = true)
class FindMember(private val memberRepository: MemberRepository) {
    fun findMemberByEmail(email: String): Member? {
        return memberRepository.findByEmail(email)
    }

    fun findMemberByGradeAndClassNumAndNumber(grade: Int, classNum: Int, number: Int): Member? {
        return memberRepository.findByGradeAndClassNumAndNumber(grade, classNum, number)
    }
}