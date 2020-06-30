package com.example.demo.business.application.user;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
public class UserDto {

    @Getter @Setter @NonNull
    private Long id;

    @Getter @Setter @NonNull
    private String name;

    @Getter @Setter @NonNull
    private String username;

}
