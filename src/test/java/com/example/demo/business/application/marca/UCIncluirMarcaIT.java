package com.example.demo.business.application.marca;

import com.example.demo.business.application.marcas.MarcaDto;
import com.example.demo.business.application.marcas.UCIncluirMarca;
import com.example.demo.config.AbstractSpringIT;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolationException;

public class UCIncluirMarcaIT extends AbstractSpringIT {

    @Test
    public void incluirMarca(){
        UCIncluirMarca uc = new UCIncluirMarca();
        uc.setName("Marca Nome");
        MarcaDto dto = executor.execute(uc);
        Assert.assertNotNull(dto);
        Assert.assertEquals(dto.getName(), uc.getName());
    }

    @Test(expected = ConstraintViolationException.class)
    public void erro_incluirMarca(){
        UCIncluirMarca uc = new UCIncluirMarca();
        MarcaDto dto = executor.execute(uc);
    }

}
