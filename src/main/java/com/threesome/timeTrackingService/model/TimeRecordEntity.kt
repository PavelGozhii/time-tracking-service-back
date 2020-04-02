package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "time_record", schema = "public", catalog = "time-tracking-service")
open class TimeRecordEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "time", nullable = false)
    var time: java.sql.Time? = null
    @get:Basic
    @get:Column(name = "date", nullable = false)
    var date: java.sql.Date? = null
    @get:Basic
    @get:Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    var userId: Int? = null
    @get:Basic
    @get:Column(name = "task_id", nullable = false, insertable = false, updatable = false)
    var taskId: Int? = null

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "user_id", referencedColumnName = "id")
    var refUserEntity: UserEntity? = null
    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "task_id", referencedColumnName = "id")
    var refTaskEntity: TaskEntity? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "time = $time " +
                    "date = $date " +
                    "userId = $userId " +
                    "taskId = $taskId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as TimeRecordEntity

        if (id != other.id) return false
        if (time != other.time) return false
        if (date != other.date) return false
        if (userId != other.userId) return false
        if (taskId != other.taskId) return false

        return true
    }

}

