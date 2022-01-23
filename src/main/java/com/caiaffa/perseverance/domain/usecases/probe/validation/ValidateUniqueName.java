package com.caiaffa.perseverance.domain.usecases.probe.validation;

import com.caiaffa.perseverance.domain.PerseveranceException;
import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.domain.probe.ProbeRepository;

public class ValidateUniqueName implements  ValidationProbe{

    private final ProbeRepository repository;

    public ValidateUniqueName(ProbeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Probe probe) {
        boolean existsByName = repository.existsByName(probe.getName());
        if (existsByName) {
            throw new PerseveranceException("Name must be unique");
        }
    }
}
