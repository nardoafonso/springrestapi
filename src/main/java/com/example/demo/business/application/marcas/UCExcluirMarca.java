package com.example.demo.business.application.marcas;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.commons.validation.SecondStageValidation;
import com.example.demo.business.entity.marcas.MarcaRepository;
import com.example.demo.business.entity.patrimonio.PatrimonioRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import static com.example.demo.business.entity.patrimonio.QPatrimonio.patrimonio;

@NoArgsConstructor
@RequiredArgsConstructor
public class UCExcluirMarca implements UseCase<Void> {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @NotNull(message = "id is required")
    @Getter @Setter @NonNull
    private Long id;

    @AssertTrue(message = "marca_related_to_patrimonio", groups = SecondStageValidation.class)
    public boolean isMarcaRelacionada(){
        return !patrimonioRepository.exists(patrimonio.marca.id.eq(id));
    }

    @Override
    public Void execute() {
        marcaRepository.deleteById(this.id);
        return null;
    }
}
