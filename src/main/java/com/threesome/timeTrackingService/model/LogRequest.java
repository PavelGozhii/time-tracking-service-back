package com.threesome.timeTrackingService.model;

import javax.persistence.*;

@Entity
@Table(name = "log_request", schema = "public", catalog = "time-tracking-service")
public class LogRequest {

    @Id
    @Column(name = "ticket", nullable = false)
    private String ticket;
    @Basic
    @Column(name = "request_body", nullable = false)
    private String requestBody;
    @Basic
    @Column(name = "operation", nullable = false)
    private String operation;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
