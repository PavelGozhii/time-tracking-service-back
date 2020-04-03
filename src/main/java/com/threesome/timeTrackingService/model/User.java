package com.threesome.timeTrackingService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", schema = "public", catalog = "time-tracking-service")
public class User {

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "login", nullable = false)
    private String login;
    @Basic
    @Column(name = "password", nullable = false)
    private String password;
    @Basic
    @Column(name = "birth_date", nullable = true)
    private String birthDate;
    @Basic
    @Column(name = "email", nullable = false)
    private String email;
    @Basic
    @Column(name = "telegram", nullable = true)
    private String telegram;
    @Basic
    @Column(name = "status", nullable = false)
    private String status;
    @Basic
    @Column(name = "working_days", nullable = true)
    private String workingDays;
    @Basic
    @Column(name = "total_hours_in_week", nullable = true)
    private Integer totalHoursInWeek;
    @Basic
    @Column(name = "team_id", nullable = false, insertable = false, updatable = false)
    private Integer teamId;
    @Basic
    @Column(name = "organization_id", nullable = false, insertable = false, updatable = false)
    private Integer organizationId;
    @Basic
    @Column(name = "role_id", nullable = false, insertable = false, updatable = false)
    private Integer roleId;
    @OneToMany(mappedBy = "refUser")
    private List<EventUser> refEventUsers;
    @OneToMany(mappedBy = "refUserOwner")
    private List<Task> refTaskOwners;
    @OneToMany(mappedBy = "refUserOwner")
    private List<Task> refTaskExecutors;
    @OneToMany(mappedBy = "refUser")
    private List<TaskComment> refTaskComments;
    @OneToMany(mappedBy = "refUser")
    private List<TimeRecord> refTimeRecords;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team refTeam;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization refOrganization;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role refRole;
}
