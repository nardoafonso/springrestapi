package com.example.demo.business.application.marcas;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MarcaDto {
    @Getter @Setter
    private Long id;
    @Getter @Setter @NonNull
    private String name;
}
