package com.example.projetospringinicial.controller;

import com.example.projetospringinicial.domain.dto.TurmaDto;
import com.example.projetospringinicial.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TurmaDto> criar(@Valid @RequestBody TurmaDto dto) {
        TurmaDto criada = service.criar(dto);
        return ResponseEntity.created(URI.create("/turmas/" + criada.getId())).body(criada);
    }

    @GetMapping("/{turmaId}")
    public ResponseEntity<TurmaDto> buscarPorId(@PathVariable Long turmaId) {
        return ResponseEntity.ok(service.buscarPorId(turmaId));
    }

    @GetMapping
    public ResponseEntity<List<TurmaDto>> buscarTodas() {
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<TurmaDto> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    @GetMapping("/periodo/{periodo}")
    public ResponseEntity<List<TurmaDto>> buscarPorPeriodo(@PathVariable String periodo) {
        return ResponseEntity.ok(service.buscarPorPeriodo(periodo));
    }

    @GetMapping("/curso/{curso}")
    public ResponseEntity<List<TurmaDto>> buscarPorCurso(@PathVariable String curso) {
        return ResponseEntity.ok(service.buscarPorCurso(curso));
    }

    @DeleteMapping("/{turmaId}")
    public ResponseEntity<Void> deletar(@PathVariable Long turmaId) {
        service.deletarPorId(turmaId);
        return ResponseEntity.noContent().build();
    }
}
