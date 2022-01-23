package com.caiaffa.perseverance.domain.usecases.probe;

import com.caiaffa.perseverance.domain.PerseveranceException;
import com.caiaffa.perseverance.domain.direction.Direction;
import com.caiaffa.perseverance.domain.position.Position;
import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.domain.probe.ProbeRepository;
import com.caiaffa.perseverance.domain.usecases.probe.validation.ValidateUniqueName;
import com.caiaffa.perseverance.domain.usecases.probe.validation.ValidateUniqueProbePosition;
import com.caiaffa.perseverance.domain.usecases.probe.validation.ValidationProbe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SaveProbeTest {

    @Mock
    private ProbeRepository probeRepository;
    private SaveProbe saveProbe;
    private Probe probe;

    @Before
    public void setup() {
        List<ValidationProbe> validations = Arrays.asList(
                new ValidateUniqueName(probeRepository),
                new ValidateUniqueProbePosition(probeRepository));

        this.saveProbe = new SaveProbe(probeRepository, validations);
        this.probe = new Probe("mark 3", new Position(0, 0), Direction.N);
    }

    @Test
    public void shouldSaveNewProbe(){
        Mockito.when(probeRepository.existsByName(probe.getName())).thenReturn(false);
        Mockito.when(probeRepository.existsByPosition(probe.getPosition().getX(), probe.getPosition().getY())).thenReturn(false);
        Mockito.when(probeRepository.save(probe)).thenReturn(probe);
        saveProbe.save(probe);
    }

    @Test(expected = PerseveranceException.class)
    public void shouldReturnExceptionWithNotUniqueName() {
        Mockito.when(probeRepository.existsByName(probe.getName())).thenReturn(true);
        Mockito.when(probeRepository.existsByPosition(probe.getPosition().getX(), probe.getPosition().getY())).thenReturn(false);
        Mockito.when(probeRepository.save(probe)).thenReturn(probe);
        saveProbe.save(probe);
    }

    @Test(expected = PerseveranceException.class)
    public void shouldReturnExceptionWithNotUniquePosition() {
        Mockito.when(probeRepository.existsByName(probe.getName())).thenReturn(false);
        Mockito.when(probeRepository.existsByPosition(probe.getPosition().getX(), probe.getPosition().getY())).thenReturn(true);
        Mockito.when(probeRepository.save(probe)).thenReturn(probe);
        saveProbe.save(probe);
    }
}
