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

import java.util.List;

import static org.junit.Assert.assertNotEquals;


@RunWith(MockitoJUnitRunner.class)
public class MoveProbeTest {

    @Mock
    private ProbeRepository probeRepository;
    private MoveProbe moveProbe;
    private Probe probe;
    private String commands;

    @Before
    public void setup() {
        List<ValidationProbe> validations = List.of(
                new ValidateUniqueProbePosition(probeRepository));

        this.commands = "MM";
        this.moveProbe = new MoveProbe(probeRepository, validations);
        this.probe = new Probe(1L, "mark 3", new Position(0, 0), Direction.N);
    }

    @Test
    public void shouldMoveProbe(){
        Mockito.when(probeRepository.existsByPosition(probe.getPosition().getX(), probe.getPosition().getY())).thenReturn(false);
        Mockito.when(probeRepository.findById(probe.getId())).thenReturn(probe);
        Mockito.when(probeRepository.update(probe)).thenReturn(new Probe(1L, "mark 3", new Position(0, 2), Direction.N));
        Probe updatedProbe = moveProbe.move(probe, commands);
        assertNotEquals(updatedProbe.getPosition().getX(), probe.getPosition().getY());
    }

    @Test(expected = PerseveranceException.class)
    public void shouldReturnExceptionWhenMoveWithNotUniquePosition() {
        Probe updatedProbe = new Probe(1L, "mark 3", new Position(0, 2), Direction.N);
        Mockito.when(probeRepository.update(probe)).thenReturn(updatedProbe);
        Mockito.when(probeRepository.findById(probe.getId())).thenReturn(probe);
        Mockito.when(probeRepository.existsByPosition(updatedProbe.getPosition().getX(), updatedProbe.getPosition().getY())).thenReturn(true);
        moveProbe.move(probe, commands);
        assertNotEquals(updatedProbe.getPosition().getX(), probe.getPosition().getY());
    }

}
