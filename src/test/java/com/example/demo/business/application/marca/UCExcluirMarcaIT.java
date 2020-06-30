package com.example.demo.business.application.marca;

import com.example.demo.business.application.marcas.MarcaDto;
import com.example.demo.business.application.marcas.UCExcluirMarca;
import com.example.demo.business.entity.marcas.Marca;
import com.example.demo.config.AbstractSpringIT;
import org.junit.Assert;
import org.junit.Test;

public class UCExcluirMarcaIT extends AbstractSpringIT {

    @Test
    public void excluirMarca(){
        UCExcluirMarca uc = new UCExcluirMarca(1L);
        executor.execute(uc);
        Marca marca = session.get(Marca.class, 1L);
        Assert.assertNull(marca);
    }


}
