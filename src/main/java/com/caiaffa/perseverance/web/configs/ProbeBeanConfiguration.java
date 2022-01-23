package com.caiaffa.perseverance.web.configs;

import com.caiaffa.perseverance.domain.position.PositionRepository;
import com.caiaffa.perseverance.domain.probe.ProbeRepository;
import com.caiaffa.perseverance.domain.usecases.probe.*;
import com.caiaffa.perseverance.domain.usecases.probe.validation.ValidateUniqueName;
import com.caiaffa.perseverance.domain.usecases.probe.validation.ValidateUniqueProbePosition;
import com.caiaffa.perseverance.domain.usecases.probe.validation.ValidationProbe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ProbeBeanConfiguration {

    private final ProbeRepository probeRepository;
    private final PositionRepository positionRepository;

    public ProbeBeanConfiguration(ProbeRepository probeRepository, PositionRepository positionRepository) {
        this.probeRepository = probeRepository;
        this.positionRepository = positionRepository;
    }

    @Bean
    public SaveProbe saveProbe() {
        return new SaveProbe(probeRepository, validationSaveProbe());
    }

    @Bean
    public FindProbe findProbe() {
        return new FindProbe(probeRepository);
    }

    @Bean
    public MoveProbe moveProbe() {
        return new MoveProbe(probeRepository, validationMoveProbe());
    }

    @Bean
    public ListProbe listProbe() {
        return new ListProbe(probeRepository);
    }

    @Bean
    public RemoveProbe removeProbe() {
        return new RemoveProbe(probeRepository);
    }

    @Bean
    public List<ValidationProbe> validationSaveProbe() {
        return Arrays.asList(
                new ValidateUniqueName(probeRepository),
                new ValidateUniqueProbePosition(probeRepository));
    }
    @Bean
    public List<ValidationProbe> validationMoveProbe() {
        return List.of(
                new ValidateUniqueProbePosition(probeRepository));
    }

}
