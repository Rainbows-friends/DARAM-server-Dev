package rainbowfriends.daramserverdev.global.member.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.global.member.entity.Member
import rainbowfriends.daramserverdev.global.member.repository.MemberRepository

@Component
class SaveMember(private val memberRepository: MemberRepository) {
    fun saveMember(member: Member): Member {
        return memberRepository.save(member)
    }
}