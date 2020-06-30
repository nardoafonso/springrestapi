package com.example.demo.business.application.marcas;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.entity.marcas.MarcaRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
public class UCListarMarca implements UseCase<List<MarcaDto>> {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired MarcaMapper marcaMapper;

    @Override
    public List<MarcaDto> execute() {
        return marcaMapper.toListMarcaDto(marcaRepository.findAll());
    }
}
