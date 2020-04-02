package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "subscription", schema = "public", catalog = "time-tracking-service")
open class SubscriptionEntity {
    @get:Id
    @get:Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null
    @get:Basic
    @get:Column(name = "name", nullable = false)
    var name: String? = null
    @get:Basic
    @get:Column(name = "duration", nullable = false)
    var duration: Int? = null
    @get:Basic
    @get:Column(name = " usage", nullable = false)
    var usage: Int? = null
    @get:Basic
    @get:Column(name = "price", nullable = false)
    var price: Float? = null

    @get:OneToMany(mappedBy = "refSubscriptionEntity")
    var refPurсhasedSubscriptionEntities: List<PurсhasedSubscriptionEntity>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "name = $name " +
                    "duration = $duration " +
                    " Usage = $usage " +
                    "price = $price " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as SubscriptionEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (duration != other.duration) return false
        if (usage != other.usage) return false
        if (price != other.price) return false

        return true
    }

}

