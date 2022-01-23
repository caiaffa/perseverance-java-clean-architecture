package com.caiaffa.perseverance.domain.usecases.probe;

import com.caiaffa.perseverance.domain.position.Position;
import com.caiaffa.perseverance.domain.position.PositionRepository;
import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.domain.probe.ProbeRepository;
import com.caiaffa.perseverance.domain.usecases.probe.validation.ValidationProbe;

import java.util.List;

public class MoveProbe {

    private final List<ValidationProbe> validations;
    private final ProbeRepository probeRepository;

    public MoveProbe(ProbeRepository probeRepository, List<ValidationProbe> validations) {
        this.probeRepository = probeRepository;
        this.validations = validations;
    }

    public Probe move(Long id, String commands) {

        Probe probe = probeRepository.findById(id);
        Long positionId = probe.getPosition().getId();

        for (char command: commands.toCharArray()) {
            newPosition(command, probe);
        }

        probe.setPosition(new Position(positionId, probe.getPosition().getX(), probe.getPosition().getY()));

        validations.forEach(v -> v.validate(probe));

        return probeRepository.update(probe);
    }

    private void newPosition(char command, Probe probe) {
        switch (command) {
            case 'L':
                probe.rotateLeft();
            case 'R':
                probe.rotateRight();
            case 'M':
                probe.move();
        }
    }
}
