package com.caiaffa.perseverance.domain.usecases.probe;

import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.domain.probe.ProbeRepository;

import java.util.List;

public class ListProbe {

    private final ProbeRepository probeRepository;

    public ListProbe(ProbeRepository probeRepository) {
        this.probeRepository = probeRepository;
    }

    public List<Probe> listAll() {
        return probeRepository.listAll();
    }
}
