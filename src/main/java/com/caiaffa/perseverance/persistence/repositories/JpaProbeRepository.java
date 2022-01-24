package com.caiaffa.perseverance.persistence.repositories;

import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.domain.probe.ProbeRepository;
import com.caiaffa.perseverance.persistence.converters.PositionEntityConverter;
import com.caiaffa.perseverance.persistence.converters.ProbeEntityConverter;
import com.caiaffa.perseverance.persistence.entities.PositionEntity;
import com.caiaffa.perseverance.persistence.entities.ProbeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaProbeRepository implements ProbeRepository {

    private final EntityManager manager;
    private final ProbeEntityConverter converter;

    public JpaProbeRepository(EntityManager manager, ProbeEntityConverter converter) {
        this.manager = manager;
        this.converter = converter;
    }

    @Transactional
    @Override
    public Probe save(Probe probe) {
        ProbeEntity probeEntity = converter.convertToProbeEntity(probe);
        manager.persist(probeEntity);
        manager.flush();
        return converter.convertToProbe(probeEntity);
    }

    @Transactional
    @Override
    public Probe update(Probe probe) {
        ProbeEntity probeEntity = converter.convertToProbeEntity(probe);
        manager.merge(probeEntity);
        manager.flush();
        return converter.convertToProbe(probeEntity);
    }

    @Override
    public List<Probe> listAll() {
        return manager
                .createQuery("SELECT p FROM Probe p", ProbeEntity.class)
                .getResultList()
                .stream()
                .map(converter::convertToProbe)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByName(String name) {
        try {
            manager.createQuery("SELECT p.id FROM Probe p WHERE p.name = :name", Long.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public boolean existsByPosition(int x, int y) {
        try {
            manager.createQuery("SELECT p.id FROM Probe p INNER JOIN p.position po WHERE po.x = :x and po.y = :y", Long.class)
                    .setParameter("x", x)
                    .setParameter("y", y)
                    .getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public Probe findById(Long id) {
        ProbeEntity probeEntity = manager.find(ProbeEntity.class, id);
        if (probeEntity == null) {
            throw new EntityNotFoundException("Probe not found");
        }
        return converter.convertToProbe(probeEntity);
    }

    @Transactional
    @Override
    public void removeById(Long id) {
        ProbeEntity probeEntity = manager.find(ProbeEntity.class, id);
        if (probeEntity == null) {
            throw new EntityNotFoundException("Probe not found");
        }
        manager.remove(probeEntity);
    }

}
