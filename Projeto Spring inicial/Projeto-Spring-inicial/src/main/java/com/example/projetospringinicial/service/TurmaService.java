package com.example.projetospringinicial.service;

import com.example.projetospringinicial.domain.dto.TurmaDto;
import com.example.projetospringinicial.domain.entity.TurmaEntity;
import java.util.List;
import java.util.Optional;

public interface TurmaService {
    TurmaEntity salvar(TurmaDto dto);
    Optional<TurmaEntity> buscarPorId(Long id);
    List<TurmaEntity> listarTodas();
    TurmaEntity atualizar(Long id, TurmaDto dto);
    void deletar(Long id);
}
