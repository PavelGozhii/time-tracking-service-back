package com.threesome.timeTrackingService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role", schema = "public", catalog = "time-tracking-service")
public class Role {

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "refRole")
    private List<User> refUsers;
}
