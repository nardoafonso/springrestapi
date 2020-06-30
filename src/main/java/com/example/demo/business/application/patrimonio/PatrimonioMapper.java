package com.example.demo.business.application.patrimonio;

import com.example.demo.business.entity.patrimonio.Patrimonio;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel="spring")
public interface PatrimonioMapper {
    PatrimonioDto patrimonioToPatrimonioDto(Patrimonio entity);
    Patrimonio useCaseToPatrimonio(UCIncuirPatrimonio uc);
    List<PatrimonioDto> toListPatrimonioDto(List<Patrimonio> entities);
    void updatePatrimonio(UCAlterarPatrimonio uc, @MappingTarget Patrimonio entity);
}
