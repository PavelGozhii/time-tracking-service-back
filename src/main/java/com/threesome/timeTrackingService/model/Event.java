package com.threesome.timeTrackingService.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "event", schema = "public", catalog = "time-tracking-service")
public class Event {

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;

    @Basic
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Basic
    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "refEvent")
    private List<EventUser> refEventUser;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", refEventUser=" + refEventUser +
                '}';
    }
}
