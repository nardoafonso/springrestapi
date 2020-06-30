package com.example.demo.business.application.patrimonio;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.entity.patrimonio.PatrimonioRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@RequiredArgsConstructor
public class UCExcluirPatrimonio implements UseCase<Void> {

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @NotNull(message = "id is required")
    @Getter @Setter @NonNull
    private Long id;

    @Override
    public Void execute() {
        patrimonioRepository.deleteById(this.id);
        return null;
    }
}
