package com.example.demo.business.application.marcas;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.commons.validation.SecondStageValidation;
import com.example.demo.business.entity.marcas.Marca;
import com.example.demo.business.entity.marcas.MarcaRepository;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.Optional;

import static com.example.demo.business.entity.marcas.QMarca.marca;

public class UCAlterarMarca implements UseCase<MarcaDto> {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MarcaMapper marcaMapper;

    @NotNull(message = "id is required")
    @Getter @Setter @NonNull
    private Long id;

    @NotNull(message = "name is required")
    @Getter @Setter @NonNull
    private String name;

    @AssertTrue(message = "marca_not_unique", groups = SecondStageValidation.class)
    public boolean isUnicidadeMarca(){
        return !marcaRepository.exists(marca.name.toUpperCase().eq(name.toUpperCase()));
    }

    @Override
    public MarcaDto execute() {
        Optional<Marca> marca = marcaRepository.findById(this.id);
        if(marca.isPresent()){
            marcaMapper.updateMarca(this, marca.get());
            return marcaMapper.marcaToMarcaDto(marcaRepository.save(marca.get()));
        }
        return null;
    }
}
