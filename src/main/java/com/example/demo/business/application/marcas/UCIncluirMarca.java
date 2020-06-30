package com.example.demo.business.application.marcas;

import com.example.demo.business.commons.validation.SecondStageValidation;
import com.example.demo.business.commons.UseCase;
import com.example.demo.business.entity.marcas.Marca;
import com.example.demo.business.entity.marcas.MarcaRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import static com.example.demo.business.entity.marcas.QMarca.marca;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@NoArgsConstructor
public class UCIncluirMarca implements UseCase<MarcaDto> {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MarcaMapper marcaMapper;

    @AssertTrue(message = "marca_not_unique", groups = SecondStageValidation.class)
    public boolean isUnicidadeMarca(){
        return !marcaRepository.exists(marca.name.toUpperCase().eq(name.toUpperCase()));
    }

    @NotNull(message = "name is required")
    @Getter @Setter @NonNull
    private String name;

    @Override
    public MarcaDto execute() {
        Marca marca = marcaMapper.useCaseToMarca(this);
        return marcaMapper.marcaToMarcaDto(marcaRepository.save(marca));
    }
}
