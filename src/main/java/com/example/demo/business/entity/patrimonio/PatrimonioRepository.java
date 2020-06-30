package com.example.demo.business.entity.patrimonio;

import com.example.demo.business.commons.EntityRepository;
import com.example.demo.business.entity.marcas.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatrimonioRepository extends EntityRepository<Patrimonio,Long> {
    List<Patrimonio> findAllByMarca(Marca marca);
}
