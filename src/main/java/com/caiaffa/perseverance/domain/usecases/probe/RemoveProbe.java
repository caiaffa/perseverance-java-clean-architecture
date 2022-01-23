package com.caiaffa.perseverance.domain.usecases.probe;

import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.domain.probe.ProbeRepository;

public class RemoveProbe {

    private final ProbeRepository probeRepository;

    public RemoveProbe(ProbeRepository probeRepository) {
        this.probeRepository = probeRepository;
    }

    public void removeById(Long id) {probeRepository.removeById(id);}
}
