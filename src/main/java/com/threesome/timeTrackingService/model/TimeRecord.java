package com.threesome.timeTrackingService.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "time_record", schema = "public", catalog = "time-tracking-service")
public class TimeRecord {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "time", nullable = false)
    private Time time;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    private Integer userId;
    @Basic
    @Column(name = "task_id", nullable = false, insertable = false, updatable = false)
    private Integer taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User refUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task refTask;

}
