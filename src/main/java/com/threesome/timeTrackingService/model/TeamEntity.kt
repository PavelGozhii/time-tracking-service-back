package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "team", schema = "public", catalog = "time-tracking-service")
open class TeamEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "name", nullable = false)
    var name: String? = null
    @get:Basic
    @get:Column(name = "description", nullable = true)
    var description: String? = null
    @get:Basic
    @get:Column(name = "organization_id", nullable = false, insertable = false, updatable = false)
    var organizationId: Int? = null

    @get:OneToOne(mappedBy = "refTeamEntity")
    var refProjectEntity: ProjectEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "organization_id", referencedColumnName = "id")
    var refOrganizationEntity: OrganizationEntity? = null
    @get:OneToMany(mappedBy = "refTeamEntity")
    var refUserEntities: List<UserEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "name = $name " +
                    "description = $description " +
                    "organizationId = $organizationId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as TeamEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (organizationId != other.organizationId) return false

        return true
    }

}

