package com.example.demo.business.application.patrimonio;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.commons.validation.SecondStageValidation;
import com.example.demo.business.entity.marcas.Marca;
import com.example.demo.business.entity.patrimonio.Patrimonio;
import com.example.demo.business.entity.patrimonio.PatrimonioRepository;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import static com.example.demo.business.entity.patrimonio.QPatrimonio.patrimonio;

public class UCAlterarPatrimonio implements UseCase<PatrimonioDto> {

    @Autowired
    private PatrimonioMapper patrimonioMapper;

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @NotNull(message = "id is required")
    @Getter @Setter @NonNull
    private Long id;
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
        Optional<Patrimonio> patrimonio = patrimonioRepository.findById(this.id);
        if(patrimonio.isPresent()){
            patrimonioMapper.updatePatrimonio(this,patrimonio.get());
            return patrimonioMapper.patrimonioToPatrimonioDto(patrimonioRepository.save(patrimonio.get()));
        }
        return null;
    }
}
