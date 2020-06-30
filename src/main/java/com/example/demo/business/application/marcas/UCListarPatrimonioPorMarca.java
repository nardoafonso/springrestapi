package com.example.demo.business.application.marcas;

import com.example.demo.business.application.patrimonio.PatrimonioDto;
import com.example.demo.business.application.patrimonio.PatrimonioMapper;
import com.example.demo.business.commons.UseCase;
import com.example.demo.business.entity.marcas.Marca;
import com.example.demo.business.entity.marcas.MarcaRepository;
import com.example.demo.business.entity.patrimonio.Patrimonio;
import com.example.demo.business.entity.patrimonio.PatrimonioRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@RequiredArgsConstructor
public class UCListarPatrimonioPorMarca implements UseCase<List<PatrimonioDto>> {

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private PatrimonioMapper patrimonioMapper;

    @NotNull(message = "id is required")
    @Getter @Setter @NonNull
    private Long id;

    @Override
    public List<PatrimonioDto> execute() {
        Optional<Marca> marca = marcaRepository.findById(this.id);
        if(marca.isPresent()){
            List<Patrimonio> patrimonios = patrimonioRepository.findAllByMarca(marca.get());
            return patrimonioMapper.toListPatrimonioDto(patrimonios);
        }else{
            return null;
        }
    }
}
