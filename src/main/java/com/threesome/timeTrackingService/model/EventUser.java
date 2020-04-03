package com.threesome.timeTrackingService.model;

import javax.persistence.*;

@Entity
@Table(name = "event_user", schema = "public", catalog = "time-tracking-service")
public class EventUser {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "event_id", nullable = false, insertable = false, updatable = false)
    private Integer eventId;

    @Basic
    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    private Integer userId;

    @Basic
    @Column(name = "accepted", nullable = false)
    private Boolean accepted;

    @Basic
    @Column(name = "no_accepted_reason", nullable = true)
    private String noAcceptedReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event refEvent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User refUser;

}
