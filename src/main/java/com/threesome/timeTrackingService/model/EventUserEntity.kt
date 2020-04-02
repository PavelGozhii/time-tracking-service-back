package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "event_user", schema = "public", catalog = "time-tracking-service")
open class EventUserEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "event_id", nullable = false, insertable = false, updatable = false)
    var eventId: Int? = null
    @get:Basic
    @get:Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    var userId: Int? = null
    @get:Basic
    @get:Column(name = "accepted", nullable = false)
    var accepted: java.lang.Boolean? = null
    @get:Basic
    @get:Column(name = "no_accepted_reason", nullable = true)
    var noAcceptedReason: String? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "event_id", referencedColumnName = "id")
    var refEventEntity: EventEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "user_id", referencedColumnName = "id")
    var refUserEntity: UserEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "eventId = $eventId " +
                    "userId = $userId " +
                    "accepted = $accepted " +
                    "noAcceptedReason = $noAcceptedReason " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EventUserEntity

        if (id != other.id) return false
        if (eventId != other.eventId) return false
        if (userId != other.userId) return false
        if (accepted != other.accepted) return false
        if (noAcceptedReason != other.noAcceptedReason) return false

        return true
    }

}

