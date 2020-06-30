package com.example.demo.business.application.marcas;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.entity.marcas.Marca;
import com.example.demo.business.entity.marcas.MarcaRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@NoArgsConstructor
@RequiredArgsConstructor
public class UCObterMarca implements UseCase<MarcaDto> {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MarcaMapper marcaMapper;

    @NotNull(message = "id is required")
    @Getter @Setter @NonNull
    private Long id;

    @Override
    public MarcaDto execute() {
        Optional<Marca> marca = marcaRepository.findById(this.id);
        if(marca.isPresent()){
            return marcaMapper.marcaToMarcaDto(marca.get());
        }else{
            return null;
        }

    }
}
