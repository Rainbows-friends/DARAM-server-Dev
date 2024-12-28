package rainbowfriends.daramserverdev.domain.member.dto.request

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

data class PatchRoomRequest(
    @field:NotNull
    @field:Max(3418)
    @field:Min(1101)
    val studentId: Short,
    @field:NotNull
    @field:Max(520)
    @field:Min(201)
    val room: Short
)