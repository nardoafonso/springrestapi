package com.example.demo.business.commons.validation;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
    @Getter @Setter @NonNull
    String message;

    @Getter @Setter @NonNull
    int status;
}
