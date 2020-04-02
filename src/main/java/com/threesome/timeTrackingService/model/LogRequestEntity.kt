package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "log_request", schema = "public", catalog = "time-tracking-service")
open class LogRequestEntity {
    @get:Id
    @get:Column(name = "ticket", nullable = false)
    var ticket: String? = null
    @get:Basic
    @get:Column(name = "request_body", nullable = false)
    var requestBody: String? = null
    @get:Basic
    @get:Column(name = "operation", nullable = false)
    var operation: String? = null


    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "ticket = $ticket " +
                    "requestBody = $requestBody " +
                    "operation = $operation " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as LogRequestEntity

        if (ticket != other.ticket) return false
        if (requestBody != other.requestBody) return false
        if (operation != other.operation) return false

        return true
    }

}

