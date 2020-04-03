package com.threesome.timeTrackingService.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team", schema = "public", catalog = "time-tracking-service")
public class Team {

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
    @Column(name = "organization_id", nullable = false, insertable = false, updatable = false)
    private Integer organizationId;

    @OneToOne(mappedBy = "refTeam")
    private Project refProject;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization refOrganization;
    @OneToMany(mappedBy = "refTeam")
    private List<User> refUsers;
}
