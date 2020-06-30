package com.example.demo.external.api.patrimonio;

import com.example.demo.business.application.patrimonio.*;
import com.example.demo.business.commons.UseCaseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patrimonios")
public class PatrimonioController {

    @Autowired
    private UseCaseExecutor executor;

    @GetMapping
    public List<PatrimonioDto> getAllPatrimonio(){
        return executor.execute(new UCListarPatrimonio());
    }

    @GetMapping(path="/{id}")
    public PatrimonioDto getPatrimonio(@PathVariable Long id){
        return executor.execute(new UCObterPatrimonio(id));
    }

    @PostMapping
    public PatrimonioDto savePatrimonio(@RequestBody UCIncuirPatrimonio uc){
        return executor.execute(uc);
    }

    @PutMapping(path = "/{id}")
    public PatrimonioDto updatePatrimonio(@RequestBody UCAlterarPatrimonio uc){
        return executor.execute(uc);
    }

    @DeleteMapping(path="/{id}")
    public Void deletePatrimonio(@PathVariable Long id){
        return executor.execute(new UCExcluirPatrimonio(id));
    }
}
