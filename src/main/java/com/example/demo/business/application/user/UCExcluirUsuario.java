package com.example.demo.business.application.user;

import com.example.demo.business.commons.UseCase;
import com.example.demo.business.entity.user.ApplicationUserRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@RequiredArgsConstructor
public class UCExcluirUsuario implements UseCase<Void> {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private ApplicationUserMapper applicationUserMapper;

    @Getter
    @Setter
    @NonNull
    private Long id;

    @Override
    public Void execute() {
        applicationUserRepository.deleteById(id);
        return null;
    }
}