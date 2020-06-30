package com.example.demo.business.application.marcas;

import com.example.demo.business.entity.marcas.Marca;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel="spring")
public interface MarcaMapper{
    MarcaDto marcaToMarcaDto(Marca entity);

    Marca useCaseToMarca(UCIncluirMarca uc);

    List<MarcaDto> toListMarcaDto (List<Marca> entities);

    void updateMarca(UCAlterarMarca uc, @MappingTarget Marca entity);
}
