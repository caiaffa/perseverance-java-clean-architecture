package com.caiaffa.perseverance.persistence.repositories;

import com.caiaffa.perseverance.domain.position.Position;
import com.caiaffa.perseverance.domain.position.PositionRepository;
import com.caiaffa.perseverance.persistence.converters.PositionEntityConverter;
import com.caiaffa.perseverance.persistence.entities.PositionEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class JpaPositionRepository  implements PositionRepository {
    private final EntityManager manager;
    private final PositionEntityConverter converter;

    public JpaPositionRepository(EntityManager manager, PositionEntityConverter converter) {
        this.manager = manager;
        this.converter = converter;
    }

    @Transactional
    public Position save(Position position) {
        PositionEntity positionEntity = converter.convertToPositionEntity(position);
        manager.persist(positionEntity);
        manager.flush();
        return converter.convertToPosition(positionEntity);
    }
}
