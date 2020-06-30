package com.example.demo.business.application.patrimonio;

import com.example.demo.business.entity.marcas.Marca;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
public class PatrimonioDto {
    @Getter @Setter
    private Long id;

    @Getter @Setter @NonNull
    private String name;

    @Getter @Setter @NonNull
    private String description;

    @Getter @Setter @NonNull
    private String identifier;

    @Getter @Setter @NonNull
    private Marca marca;
}
