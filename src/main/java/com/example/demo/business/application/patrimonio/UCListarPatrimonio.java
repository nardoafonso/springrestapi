package com.example.demo.business.application.patrimonio;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.entity.patrimonio.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UCListarPatrimonio implements UseCase<List<PatrimonioDto>> {

    @Autowired
    private PatrimonioMapper patrimonioMapper;

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Override
    public List<PatrimonioDto> execute() {
        return patrimonioMapper.toListPatrimonioDto(patrimonioRepository.findAll());
    }
}
