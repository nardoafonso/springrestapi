package com.example.demo.external.api.user;

import com.example.demo.business.application.user.UCExcluirUsuario;
import com.example.demo.business.application.user.UCObterUsuario;
import com.example.demo.business.application.user.UserDto;
import com.example.demo.business.commons.UseCaseExecutor;
import com.example.demo.business.entity.user.ApplicationUserRepository;
import com.example.demo.business.entity.user.ApplicationUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UseCaseExecutor executor;
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(
            ApplicationUserRepository applicationUserRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            UseCaseExecutor executor){
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.executor = executor;
    }

    @PostMapping
    public void signUp(@RequestBody ApplicationUser user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    @GetMapping(path = "/{id}")
    public UserDto getUser(@PathVariable Long id){
        return executor.execute(new UCObterUsuario(id));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id){
        executor.execute(new UCExcluirUsuario(id));
    }


}
