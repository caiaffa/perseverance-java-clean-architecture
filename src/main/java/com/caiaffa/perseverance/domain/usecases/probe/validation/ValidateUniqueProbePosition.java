package com.caiaffa.perseverance.domain.usecases.probe.validation;

import com.caiaffa.perseverance.domain.PerseveranceException;
import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.domain.probe.ProbeRepository;

public class ValidateUniqueProbePosition implements ValidationProbe{
    private final ProbeRepository repository;

    public ValidateUniqueProbePosition(ProbeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Probe probe) {
        boolean existsByPosition = repository.existsByPosition(probe.getPosition().getX(), probe.getPosition().getY());
        if (existsByPosition) {
            throw new PerseveranceException("Position must be unique");
        }
    }
}
