package com.threesome.timeTrackingService.model

import javax.persistence.*

@Entity
@Table(name = "log_response", schema = "public", catalog = "time-tracking-service")
open class LogResponseEntity {
    @get:Id
    @get:Column(name = "ticket", nullable = false)
    var ticket: String? = null
    @get:Basic
    @get:Column(name = "response_body", nullable = false)
    var responseBody: String? = null
    @get:Basic
    @get:Column(name = "operation", nullable = false)
    var operation: String? = null


    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "ticket = $ticket " +
                    "responseBody = $responseBody " +
                    "operation = $operation " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as LogResponseEntity

        if (ticket != other.ticket) return false
        if (responseBody != other.responseBody) return false
        if (operation != other.operation) return false

        return true
    }

}

