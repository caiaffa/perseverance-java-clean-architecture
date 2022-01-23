package com.caiaffa.perseverance.persistence.converters;

import com.caiaffa.perseverance.domain.direction.Direction;
import com.caiaffa.perseverance.domain.position.Position;
import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.persistence.entities.PositionEntity;
import com.caiaffa.perseverance.persistence.entities.ProbeEntity;
import org.springframework.stereotype.Service;

@Service
public class ProbeEntityConverter {

    private final PositionEntityConverter positionEntityConverter;

    public ProbeEntityConverter(PositionEntityConverter positionEntityConverter) {
        this.positionEntityConverter = positionEntityConverter;
    }

    public Probe convertToProbe(ProbeEntity probeEntity) {
        Position position = positionEntityConverter.convertToPosition(probeEntity.getPosition());
        return new Probe(probeEntity.getId(), probeEntity.getName(), position, Direction.valueOf(probeEntity.getDirection()));
    }

    public ProbeEntity convertToProbeEntity(Probe probe) {
        PositionEntity positionEntity = positionEntityConverter.convertToPositionEntity(probe.getPosition());
        return new ProbeEntity(probe.getId(), probe.getName(), probe.getDirection().toString(), positionEntity);
    }
}
