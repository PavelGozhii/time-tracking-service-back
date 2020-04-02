package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "comment_type", schema = "public", catalog = "time-tracking-service")
open class CommentTypeEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "name", nullable = false)
    var name: String? = null
    @get:Basic
    @get:Column(name = "description", nullable = true)
    var description: String? = null

    @get:OneToMany(mappedBy = "refCommentTypeEntity")
    var refTaskCommentEntities: List<TaskCommentEntity>? = null

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
        other as CommentTypeEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false

        return true
    }

}

