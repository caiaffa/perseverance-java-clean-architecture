package com.caiaffa.perseverance.domain.position;

public class Position {
    private Long id;
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x =x;
        this.y = y;
    }

    public Position(Long id, int x, int y) {
        this.id = id;
        this.x =x;
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

    @Override
    public String toString() {
        return x + " " + y;
    }

    public Position toAdd(Position position) {
        return new Position(x  + position.x , y + position.y);
    }
}
