package com.caiaffa.perseverance.web.models.request;


import com.caiaffa.perseverance.domain.direction.Direction;
import com.caiaffa.perseverance.domain.position.Position;
import com.caiaffa.perseverance.domain.probe.Probe;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProbeRequest {

    @NotBlank
    private String name;

    @Valid
    private PositionRequest positionRequest;

    @NotNull
    @Pattern(regexp = "[NSEW]")
    private String direction;

    public Probe toProbe() {
        Position position = new Position(positionRequest.getX(), positionRequest.getY());
        return new Probe(name, position, Direction.valueOf(direction));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPosition(PositionRequest positionRequest) {
        this.positionRequest = positionRequest;
    }

    public PositionRequest getPosition() {
        return positionRequest;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return positionRequest.getX() + " " + positionRequest.getY() + " " + direction;
    }

}
