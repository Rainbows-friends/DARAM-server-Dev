package rainbowfriends.daramserverdev.global.checkin.component

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import rainbowfriends.daramserverdev.domain.member.exception.MemberNotFoundException
import rainbowfriends.daramserverdev.global.checkin.exception.LateNumberRaiseFailException
import rainbowfriends.daramserverdev.global.checkin.repository.CheckInRepository
import rainbowfriends.daramserverdev.global.member.repository.MemberRepository
import java.time.LocalDate

@Component
class LateNumberUpdater(
    private val checkInRepository: CheckInRepository,
    private val memberRepository: MemberRepository
) {
    @Transactional
    fun lateNumberRaise(date: LocalDate) {
        try {
            checkInRepository.findByCheckinInfoDate(date).forEach { checkIn ->
                if (!checkIn.checkinStatus) {
                    val member = memberRepository.findById(checkIn.id!!)
                        .orElseThrow { MemberNotFoundException("Member not found") }
                    member.lateNumber = member.lateNumber?.plus(1)
                    memberRepository.save(member)
                }
            }
        } catch (_: Exception) {
            throw LateNumberRaiseFailException("Late Number Raise failed")
        }
    }
}