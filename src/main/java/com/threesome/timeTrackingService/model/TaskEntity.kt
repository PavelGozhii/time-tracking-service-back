package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "task", schema = "public", catalog = "time-tracking-service")
open class TaskEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "executor_id", nullable = false, insertable = false, updatable = false)
    var executorId: Int? = null
    @get:Basic
    @get:Column(name = "owner_id", nullable = false, insertable = false, updatable = false)
    var ownerId: Int? = null
    @get:Basic
    @get:Column(name = "name", nullable = false)
    var name: String? = null
    @get:Basic
    @get:Column(name = "description", nullable = true)
    var description: String? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "executor_id", referencedColumnName = "id")
    var refUserOwnerEntity: UserEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "owner_id", referencedColumnName = "id")
    var refUserExecutorEntity: UserEntity? = null
    @get:OneToMany(mappedBy = "refTaskEntity")
    var refTaskCommentEntities: List<TaskCommentEntity>? = null
    @get:OneToMany(mappedBy = "refTaskEntity")
    var refTimeRecordEntities: List<TimeRecordEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "executorId = $executorId " +
                    "ownerId = $ownerId " +
                    "name = $name " +
                    "description = $description " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as TaskEntity

        if (id != other.id) return false
        if (executorId != other.executorId) return false
        if (ownerId != other.ownerId) return false
        if (name != other.name) return false
        if (description != other.description) return false

        return true
    }

}

