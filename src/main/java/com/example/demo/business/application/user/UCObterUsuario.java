package com.example.demo.business.application.user;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.entity.user.ApplicationUserRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@RequiredArgsConstructor
public class UCObterUsuario implements UseCase<UserDto> {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private ApplicationUserMapper applicationUserMapper;

    @Getter @Setter @NonNull
    private Long id;

    @Override
    public UserDto execute() {
        return applicationUserMapper.applicationUserToUserDto(applicationUserRepository.getOne(this.id));
    }
}
