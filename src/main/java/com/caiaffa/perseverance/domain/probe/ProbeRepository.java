package com.caiaffa.perseverance.domain.probe;

import java.util.List;

public interface ProbeRepository {
    Probe save(Probe probe);
    Probe update(Probe probe);
    List<Probe> listAll();
    boolean existsByName(String name);
    boolean existsByPosition(int x, int y);
    Probe findById(Long id);
    void removeById(Long id);
}
