package com.caiaffa.perseverance.web.models.request;

import javax.validation.constraints.Min;

public class PositionRequest {

    @Min(0)
    private int x;

    @Min(0)
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
