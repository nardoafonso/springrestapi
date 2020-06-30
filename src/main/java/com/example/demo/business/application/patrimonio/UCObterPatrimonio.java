package com.example.demo.business.application.patrimonio;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.entity.patrimonio.Patrimonio;
import com.example.demo.business.entity.patrimonio.PatrimonioRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@NoArgsConstructor
@RequiredArgsConstructor
public class UCObterPatrimonio implements UseCase<PatrimonioDto> {

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private PatrimonioMapper patrimonioMapper;

    @NotNull(message = "id is required")
    @Getter @Setter @NonNull
    private Long id;

    @Override
    public PatrimonioDto execute() {
        Optional<Patrimonio> patrimonio = patrimonioRepository.findById(this.id);
        if(patrimonio.isPresent()){
            return patrimonioMapper.patrimonioToPatrimonioDto(patrimonio.get());
        }
        return null;
    }
}
