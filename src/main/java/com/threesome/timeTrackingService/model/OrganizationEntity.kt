package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "organization", schema = "public", catalog = "time-tracking-service")
open class OrganizationEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "name", nullable = true)
    var name: String? = null
    @get:Basic
    @get:Column(name = "description", nullable = true)
    var description: String? = null

    @get:OneToMany(mappedBy = "refOrganizationEntity")
    var refPurсhasedSubscriptionEntities: List<PurсhasedSubscriptionEntity>? = null
    @get:OneToMany(mappedBy = "refOrganizationEntity")
    var refTeamEntities: List<TeamEntity>? = null
    @get:OneToMany(mappedBy = "refOrganizationEntity")
    var refUserEntities: List<UserEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "name = $name " +
                    "description = $description " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as OrganizationEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false

        return true
    }

}

