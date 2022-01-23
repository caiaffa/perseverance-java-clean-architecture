package com.caiaffa.perseverance.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;


@Entity(name = "Position")
@Table(name = "position")
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int x;
    private int y;

    @OneToOne(mappedBy = "position")
    private ProbeEntity probe;

    public PositionEntity() {}

    public PositionEntity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PositionEntity(Long id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
