package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "event", schema = "public", catalog = "time-tracking-service")
open class EventEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "start_date", nullable = false)
    var startDate: java.sql.Timestamp? = null
    @get:Basic
    @get:Column(name = "end_date", nullable = false)
    var endDate: java.sql.Timestamp? = null
    @get:Basic
    @get:Column(name = "name", nullable = false)
    var name: String? = null
    @get:Basic
    @get:Column(name = "description", nullable = true)
    var description: String? = null

    @get:OneToMany(mappedBy = "refEventEntity")
    var refEventUserEntities: List<EventUserEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "startDate = $startDate " +
                    "endDate = $endDate " +
                    "name = $name " +
                    "description = $description " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EventEntity

        if (id != other.id) return false
        if (startDate != other.startDate) return false
        if (endDate != other.endDate) return false
        if (name != other.name) return false
        if (description != other.description) return false

        return true
    }

}

