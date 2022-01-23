package com.caiaffa.perseverance.domain.probe;

import com.caiaffa.perseverance.domain.direction.Direction;
import com.caiaffa.perseverance.domain.position.Position;

public class Probe {
    private Long id;
    private final String name;
    private Position position;
    private Direction direction;


    public Probe(String name, Position position, Direction direction) {
        this.name = name;
        this.position = position;
        this.direction = direction;
    }

    public Probe(Long id, String name, Position position, Direction direction) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.direction = direction;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return  name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void rotateLeft() {
        this.direction = this.direction.left();
    }

    public void rotateRight() {
        this.direction = this.direction.right();
    }

    public void move() {
        this.position = this.position.toAdd(this.direction.move());
    }
}
