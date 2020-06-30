package com.example.demo.business.entity.patrimonio;

import com.example.demo.business.entity.marcas.Marca;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Patrimonio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @NotNull
    @Getter @Setter @NonNull
    private String name;
    @NotNull
    @Getter @Setter @NonNull
    private String description;
    @NotNull
    @Getter @Setter @NonNull
    private String identifier;
    @OneToOne
    @NotNull
    @Getter @Setter @NonNull
    @JoinColumn(name = "marca",referencedColumnName = "id")
    private Marca marca;
}
