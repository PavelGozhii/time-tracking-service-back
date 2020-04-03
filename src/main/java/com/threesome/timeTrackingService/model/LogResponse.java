package com.threesome.timeTrackingService.model;

import javax.persistence.*;

@Entity
@Table(name = "log_response", schema = "public", catalog = "time-tracking-service")
public class LogResponse {

    @Id
    @Column(name = "ticket", nullable = false)
    private String ticket;
    @Basic
    @Column(name = "response_body", nullable = false)
    private String responseBody;
    @Basic
    @Column(name = "operation", nullable = false)
    private String operation;
}
