package com.example.demo.external.api.marca;

import com.example.demo.business.application.marcas.*;
import com.example.demo.business.application.patrimonio.PatrimonioDto;
import com.example.demo.business.commons.UseCaseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/marcas")
public class MarcaController {

    @Autowired
    private UseCaseExecutor executor;

    @GetMapping
    public List<MarcaDto> getAllMarcas(){
        return executor.execute(new UCListarMarca());
    }

    @GetMapping(path = "/{id}")
    public MarcaDto getMarca(@PathVariable Long id){
        return executor.execute(new UCObterMarca(id));
    }

    @GetMapping(path = "/{id}/patrimonio")
    public List<PatrimonioDto> getPatrimonioByMarca(@PathVariable Long id){
        return executor.execute(new UCListarPatrimonioPorMarca(id));
    }

    @PostMapping
    public MarcaDto saveMarca(@RequestBody UCIncluirMarca uc){
        return executor.execute(uc);
    }

    @PutMapping(path = "/{id}")
    public MarcaDto updateMarca(@RequestBody UCAlterarMarca uc){
        return executor.execute(uc);
    }


    @DeleteMapping(path = "/{id}")
    public Void deleteMarca(@PathVariable Long id){
        return executor.execute(new UCExcluirMarca(id));
    }
}
