package com.caiaffa.perseverance.web.controllers;

import com.caiaffa.perseverance.domain.probe.Probe;
import com.caiaffa.perseverance.domain.usecases.probe.*;
import com.caiaffa.perseverance.web.models.request.CommandRequest;
import com.caiaffa.perseverance.web.models.request.ProbeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/probes")
public class ProbesController {

    private final SaveProbe saveProbe;
    private final FindProbe findProbe;
    private final MoveProbe moveProbe;
    private final RemoveProbe removeProbe;
    private final ListProbe listProbe;

    public ProbesController(SaveProbe saveProbe, FindProbe findProbe, MoveProbe moveProbe, RemoveProbe removeProbe, ListProbe listProbe) {
        this.saveProbe = saveProbe;
        this.findProbe = findProbe;
        this.moveProbe = moveProbe;
        this.removeProbe = removeProbe;
        this.listProbe = listProbe;
    }

    @PostMapping("")
    public ResponseEntity<Probe> save(@Valid @RequestBody ProbeRequest probeRequest){
        Probe probe = saveProbe.save(probeRequest.toProbe());
        return new ResponseEntity<>(probe, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Probe>> list(){
        List<Probe> probes = listProbe.listAll();
        return new ResponseEntity<>(probes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Probe> findById(@PathVariable Long id){
        Probe probe = findProbe.findById(id);
        return new ResponseEntity<>(probe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeById(@PathVariable Long id){
        removeProbe.removeById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/move/{id}")
    public ResponseEntity<Probe> moveById(@PathVariable Long id, @Valid @RequestBody CommandRequest commandRequest){
        Probe probe = findProbe.findById(id);
        moveProbe.move(probe, commandRequest.getCommands());
        return new ResponseEntity<>(probe, HttpStatus.OK);
    }
}
