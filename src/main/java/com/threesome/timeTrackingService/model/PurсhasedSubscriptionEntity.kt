package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "purсhased_subscription", schema = "public", catalog = "time-tracking-service")
open class PurсhasedSubscriptionEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "time_to_end", nullable = false)
    var timeToEnd: java.sql.Date? = null
    @get:Basic
    @get:Column(name = "type_id", nullable = false, insertable = false, updatable = false)
    var typeId: Int? = null
    @get:Basic
    @get:Column(name = "organization_id", nullable = false, insertable = false, updatable = false)
    var organizationId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "type_id", referencedColumnName = "id")
    var refSubscriptionEntity: SubscriptionEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "organization_id", referencedColumnName = "id")
    var refOrganizationEntity: OrganizationEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "timeToEnd = $timeToEnd " +
                    "typeId = $typeId " +
                    "organizationId = $organizationId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as PurсhasedSubscriptionEntity

        if (id != other.id) return false
        if (timeToEnd != other.timeToEnd) return false
        if (typeId != other.typeId) return false
        if (organizationId != other.organizationId) return false

        return true
    }

}

