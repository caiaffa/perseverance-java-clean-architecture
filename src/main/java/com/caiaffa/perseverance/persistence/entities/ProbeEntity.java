package com.caiaffa.perseverance.persistence.entities;

import javax.persistence.Entity;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity(name = "Probe")
@Table(name = "probe")
public class ProbeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String direction;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    public ProbeEntity(){}

    public ProbeEntity(String name, String direction, PositionEntity position) {
        this.name = name;
        this.direction = direction;
        this.position = position;
    }

    public ProbeEntity(Long id, String name, String direction, PositionEntity position) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public PositionEntity getPosition() {
        return position;
    }
}
