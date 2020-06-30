package com.example.demo.business.application.marca;

import com.example.demo.business.application.marcas.MarcaDto;
import com.example.demo.business.application.marcas.UCObterMarca;
import com.example.demo.config.AbstractSpringIT;
import com.example.demo.config.SpringConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringConfig.class)
public class UCObterMarcaIT extends AbstractSpringIT {

    @Test
    public void obterMarca(){
        UCObterMarca uc = new UCObterMarca(1L);
        MarcaDto dto = executor.execute(uc);
        Assert.assertNotNull(dto);
        Assert.assertEquals(dto.getName(),"Marca");
    }
}
