package com.example.projetospringinicial.domain.mapper;

import com.example.projetospringinicial.domain.dto.TurmaDto;
import com.example.projetospringinicial.domain.entity.TurmaEntity;

public class TurmaMapper {

    public static TurmaDto toDto(TurmaEntity e) {
        if (e == null) return null;
        return new TurmaDto(e.getId(), e.getNome(), e.getPeriodo(), e.getCurso());
    }

    public static TurmaEntity toEntity(TurmaDto d) {
        if (d == null) return null;
        return new TurmaEntity(d.getId(), d.getNome(), d.getPeriodo(), d.getCurso());
    }
}
