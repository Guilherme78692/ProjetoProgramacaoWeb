package com.example.projetospringinicial.service;

import com.example.projetospringinicial.domain.dto.TurmaDto;
import com.example.projetospringinicial.domain.entity.TurmaEntity;
import com.example.projetospringinicial.domain.mapper.TurmaMapper;
import com.example.projetospringinicial.exception.BadRequestException;
import com.example.projetospringinicial.exception.NotFoundException;
import com.example.projetospringinicial.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepository repository;

    public TurmaServiceImpl(TurmaRepository repository) {
        this.repository = repository;
    }

    @Override
    public TurmaDto criar(TurmaDto dto) {
        if (dto.getNome() == null || dto.getNome().isBlank()) throw new BadRequestException("Nome é obrigatório");
        if (dto.getPeriodo() == null || dto.getPeriodo().isBlank()) throw new BadRequestException("Período é obrigatório");
        if (dto.getCurso() == null || dto.getCurso().isBlank()) throw new BadRequestException("Curso é obrigatório");
        TurmaEntity entity = TurmaMapper.toEntity(dto);
        entity.setId(null);
        return TurmaMapper.toDto(repository.save(entity));
    }

    @Override
    public TurmaDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(TurmaMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Turma não encontrada para ID: " + id));
    }

    @Override
    public List<TurmaDto> buscarTodas() {
        List<TurmaDto> lista = repository.findAll().stream().map(TurmaMapper::toDto).collect(Collectors.toList());
        if (lista.isEmpty()) throw new NotFoundException("Nenhuma turma cadastrada");
        return lista;
    }

    @Override
    public TurmaDto buscarPorNome(String nome) {
        return repository.findByNomeIgnoreCase(nome)
                .map(TurmaMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Nenhuma turma com nome: " + nome));
    }

    @Override
    public List<TurmaDto> buscarPorPeriodo(String periodo) {
        List<TurmaDto> lista = repository.findByPeriodoIgnoreCase(periodo).stream().map(TurmaMapper::toDto).collect(Collectors.toList());
        if (lista.isEmpty()) throw new NotFoundException("Nenhuma turma no período: " + periodo);
        return lista;
    }

    @Override
    public List<TurmaDto> buscarPorCurso(String curso) {
        List<TurmaDto> lista = repository.findByCursoIgnoreCase(curso).stream().map(TurmaMapper::toDto).collect(Collectors.toList());
        if (lista.isEmpty()) throw new NotFoundException("Nenhuma turma no curso: " + curso);
        return lista;
    }

    @Override
    public void deletarPorId(Long id) {
        if (!repository.existsById(id)) throw new NotFoundException("Turma não encontrada para ID: " + id);
        repository.deleteById(id);
    }
}
