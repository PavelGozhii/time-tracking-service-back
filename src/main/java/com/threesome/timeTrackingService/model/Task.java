package com.threesome.timeTrackingService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task", schema = "public", catalog = "time-tracking-service")
public class Task {

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;

    @Basic
    @Column(name = "executor_id", nullable = false, insertable = false, updatable = false)
    private Integer executorId;
    @Basic
    @Column(name = "owner_id", nullable = false, insertable = false, updatable = false)
    private Integer ownerId;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "executor_id", referencedColumnName = "id")
    private User refUserOwner;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User refUserExecutorEntity;
    @OneToMany(mappedBy = "refTask")
    private List<TaskComment> refTaskComments;
    @OneToMany(mappedBy = "refTask")
    private List<TimeRecord> refTimeRecords;
}
