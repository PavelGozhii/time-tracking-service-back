package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "task_comment", schema = "public", catalog = "time-tracking-service")
open class TaskCommentEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "writer_id", nullable = false, insertable = false, updatable = false)
    var writerId: Int? = null
    @get:Basic
    @get:Column(name = "text", nullable = false)
    var text: String? = null
    @get:Basic
    @get:Column(name = "date", nullable = false)
    var date: java.sql.Timestamp? = null
    @get:Basic
    @get:Column(name = "type_id", nullable = false, insertable = false, updatable = false)
    var typeId: Int? = null
    @get:Basic
    @get:Column(name = "task_id", nullable = false, insertable = false, updatable = false)
    var taskId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "writer_id", referencedColumnName = "id")
    var refUserEntity: UserEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "type_id", referencedColumnName = "id")
    var refCommentTypeEntity: CommentTypeEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "task_id", referencedColumnName = "id")
    var refTaskEntity: TaskEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "writerId = $writerId " +
                    "text = $text " +
                    "date = $date " +
                    "typeId = $typeId " +
                    "taskId = $taskId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as TaskCommentEntity

        if (id != other.id) return false
        if (writerId != other.writerId) return false
        if (text != other.text) return false
        if (date != other.date) return false
        if (typeId != other.typeId) return false
        if (taskId != other.taskId) return false

        return true
    }

}

