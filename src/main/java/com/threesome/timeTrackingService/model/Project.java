package com.threesome.timeTrackingService.model;


import javax.persistence.*;

@Entity
@Table(name = "project", schema = "public", catalog = "time-tracking-service")
public class Project {

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "description", nullable = true)
    private String description;
    @Basic
    @Column(name = "team_id", nullable = false)
    private Integer teamId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Team refTeam;

}
