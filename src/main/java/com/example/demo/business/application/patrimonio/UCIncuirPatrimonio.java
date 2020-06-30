package com.example.demo.business.application.patrimonio;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.commons.validation.SecondStageValidation;
import com.example.demo.business.entity.marcas.Marca;
import com.example.demo.business.entity.patrimonio.Patrimonio;
import com.example.demo.business.entity.patrimonio.PatrimonioRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static com.example.demo.business.entity.patrimonio.QPatrimonio.patrimonio;

@RequiredArgsConstructor
@NoArgsConstructor
public class UCIncuirPatrimonio implements UseCase<PatrimonioDto> {

    @Autowired
    private PatrimonioMapper patrimonioMapper;

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @NotNull(message = "name is required")
    @Getter @Setter @NonNull
    private String name;

    @NotNull(message = "description is required")
    @Getter @Setter @NonNull
    private String description;

    @NotNull(message = "marca is required")
    @Getter @Setter @NonNull
    private Marca marca;

    @AssertTrue(message = "patrimonio_not_unique", groups = SecondStageValidation.class)
    public boolean isUnicidadePatrimonio(){
        return !patrimonioRepository.exists(patrimonio.name.toUpperCase().eq(name.toUpperCase()));
    }

    @Override
    public PatrimonioDto execute() {
        String uuid = UUID.randomUUID().toString();
        Patrimonio patrimonio = patrimonioMapper.useCaseToPatrimonio(this);
        patrimonio.setIdentifier(uuid);
        return patrimonioMapper.patrimonioToPatrimonioDto(patrimonioRepository.save(patrimonio));
    }
}
