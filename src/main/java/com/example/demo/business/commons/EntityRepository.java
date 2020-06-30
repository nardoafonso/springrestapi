package com.example.demo.business.commons;
import com.querydsl.core.types.FactoryExpression;
import com.querydsl.core.types.Predicate;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface base para repositórios de entidades. Cada entidade persistente pode ter uma interface
 * própria que herda de {@link EntityRepository}.
 *
 * @param <T>  Tipo da entidade
 * @param <I> Tipo da chave da entidade
 */
@NoRepositoryBean
public interface EntityRepository<T, I extends Serializable> extends JpaRepository<T, I>,
        QuerydslPredicateExecutor<T> {

    <P> P findOne(FactoryExpression<P> factoryExpression, Predicate predicate);

    <P> List<P> findAll(FactoryExpression<P> factoryExpression, Predicate predicate);

    <P> List<P> findAll(FactoryExpression<P> factoryExpression, Predicate predicate,
                        Sort sort);

    <P> Page<P> findAll(FactoryExpression<P> factoryExpression, Predicate predicate,
                        Pageable pageable);

}
