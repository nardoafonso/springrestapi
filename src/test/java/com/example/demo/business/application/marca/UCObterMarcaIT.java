package com.example.demo.business.application.marca;

import com.example.demo.business.application.marcas.MarcaDto;
import com.example.demo.business.application.marcas.UCObterMarca;
import com.example.demo.config.AbstractSpringIT;
import org.junit.Assert;
import org.junit.Test;

public class UCObterMarcaIT extends AbstractSpringIT {

    @Test
    public void obterMarca(){
        UCObterMarca uc = new UCObterMarca(1L);
        MarcaDto dto = executor.execute(uc);
        Assert.assertNotNull(dto);
        Assert.assertEquals(dto.getName(),"Marca");
    }
}
