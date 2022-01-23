package com.caiaffa.perseverance.domain.usecases.probe;

import com.caiaffa.perseverance.domain.position.PositionRepository;
import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.domain.probe.ProbeRepository;
import com.caiaffa.perseverance.domain.usecases.probe.validation.ValidationProbe;

import java.util.List;

public class SaveProbe {

    private final List<ValidationProbe> validations;
    private final ProbeRepository probeRepository;

    public SaveProbe(ProbeRepository probeRepository, List<ValidationProbe> validations) {
        this.probeRepository = probeRepository;
        this.validations = validations;
    }

    public Probe save(Probe probe) {
        validations.forEach(v -> v.validate(probe));
        return probeRepository.save(probe);
    }
}
