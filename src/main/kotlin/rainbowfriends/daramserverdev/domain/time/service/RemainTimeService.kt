package rainbowfriends.daramserverdev.domain.time.service

import rainbowfriends.daramserverdev.domain.time.dto.enums.GetRemainTimeServiceAction

interface RemainTimeService {
    fun getRemainTime(getRemainTimeServiceAction: GetRemainTimeServiceAction): Any
}