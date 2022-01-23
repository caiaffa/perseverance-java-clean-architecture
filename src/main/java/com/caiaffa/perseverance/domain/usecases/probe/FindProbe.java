package com.caiaffa.perseverance.domain.usecases.probe;

import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.domain.probe.ProbeRepository;

public class FindProbe {

    private final ProbeRepository probeRepository;

    public FindProbe(ProbeRepository probeRepository) {
        this.probeRepository = probeRepository;
    }

    public Probe findById(Long id) {
        return probeRepository.findById(id);
    }
}
