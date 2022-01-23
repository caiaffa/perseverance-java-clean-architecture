package com.caiaffa.perseverance.persistence.converters;

import com.caiaffa.perseverance.domain.position.Position;
import com.caiaffa.perseverance.persistence.entities.PositionEntity;
import org.springframework.stereotype.Service;

@Service
public class PositionEntityConverter {

    public Position convertToPosition(PositionEntity positionEntity) {
        return new Position(positionEntity.getId(), positionEntity.getX(), positionEntity.getY());
    }

    public PositionEntity convertToPositionEntity(Position position) {
        return  new PositionEntity(position.getId(), position.getX(), position.getY());
    }

}
