package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "user", schema = "public", catalog = "time-tracking-service")
open class UserEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "name", nullable = false)
    var name: String? = null
    @get:Basic
    @get:Column(name = "login", nullable = false)
    var login: String? = null
    @get:Basic
    @get:Column(name = "password", nullable = false)
    var password: String? = null
    @get:Basic
    @get:Column(name = "birth_date", nullable = true)
    var birthDate: String? = null
    @get:Basic
    @get:Column(name = "email", nullable = false)
    var email: String? = null
    @get:Basic
    @get:Column(name = "telegram", nullable = true)
    var telegram: String? = null
    @get:Basic
    @get:Column(name = "status", nullable = false)
    var status: String? = null
    @get:Basic
    @get:Column(name = "working_days", nullable = true)
    var workingDays: String? = null
    @get:Basic
    @get:Column(name = "total_hours_in_week", nullable = true)
    var totalHoursInWeek: Int? = null
    @get:Basic
    @get:Column(name = "team_id", nullable = false, insertable = false, updatable = false)
    var teamId: Int? = null
    @get:Basic
    @get:Column(name = "organization_id", nullable = false, insertable = false, updatable = false)
    var organizationId: Int? = null
    @get:Basic
    @get:Column(name = "role_id", nullable = false, insertable = false, updatable = false)
    var roleId: Int? = null

    @get:OneToMany(mappedBy = "refUserEntity")
    var refEventUserEntities: List<EventUserEntity>? = null
    @get:OneToMany(mappedBy = "refUserOwnerEntity")
    var refTaskOwnerEntities: List<TaskEntity>? = null
    @get:OneToMany(mappedBy = "refUserOwnerEntity")
    var refTaskExecutorEntities: List<TaskEntity>? = null
    @get:OneToMany(mappedBy = "refUserEntity")
    var refTaskCommentEntities: List<TaskCommentEntity>? = null
    @get:OneToMany(mappedBy = "refUserEntity")
    var refTimeRecordEntities: List<TimeRecordEntity>? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "team_id", referencedColumnName = "id")
    var refTeamEntity: TeamEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "organization_id", referencedColumnName = "id")
    var refOrganizationEntity: OrganizationEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "role_id", referencedColumnName = "id")
    var refRoleEntity: RoleEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "name = $name " +
                    "login = $login " +
                    "password = $password " +
                    "birthDate = $birthDate " +
                    "email = $email " +
                    "telegram = $telegram " +
                    "status = $status " +
                    "workingDays = $workingDays " +
                    "totalHoursInWeek = $totalHoursInWeek " +
                    "teamId = $teamId " +
                    "organizationId = $organizationId " +
                    "roleId = $roleId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as UserEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (login != other.login) return false
        if (password != other.password) return false
        if (birthDate != other.birthDate) return false
        if (email != other.email) return false
        if (telegram != other.telegram) return false
        if (status != other.status) return false
        if (workingDays != other.workingDays) return false
        if (totalHoursInWeek != other.totalHoursInWeek) return false
        if (teamId != other.teamId) return false
        if (organizationId != other.organizationId) return false
        if (roleId != other.roleId) return false

        return true
    }

}

