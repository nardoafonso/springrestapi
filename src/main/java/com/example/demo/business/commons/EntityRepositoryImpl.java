package com.example.demo.business.commons;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.FactoryExpression;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.querydsl.SimpleEntityPathResolver;

/**
 * Extensao da implementacao padrao de repository para suportar projecoes.
 *
 * @author ur50
 * @param <T> tipo da entidade
 * @param <I> tipo do id da entidade
 */
public class EntityRepositoryImpl<T, I extends Serializable> extends QuerydslJpaRepository<T, I>
        implements EntityRepository<T, I> {

    //All instance variables are available in super, but they are private
    private static final EntityPathResolver DEFAULT_ENTITY_PATH_RESOLVER
            = SimpleEntityPathResolver.INSTANCE;

    private final Querydsl querydsl;

    public EntityRepositoryImpl(JpaEntityInformation<T, I> entityInformation,
                                EntityManager entityManager) {
        this(entityInformation, entityManager, DEFAULT_ENTITY_PATH_RESOLVER);
    }

    public EntityRepositoryImpl(JpaEntityInformation<T, I> entityInformation,
                                EntityManager entityManager,
                                EntityPathResolver resolver) {
        super(entityInformation, entityManager, resolver);
        EntityPath<T> path = resolver.createPath(entityInformation.getJavaType());
        PathBuilder<T> builder = new PathBuilder<>(path.getType(), path.getMetadata());
        this.querydsl = new Querydsl(entityManager, builder);
    }

    @Override
    public <P> P findOne(FactoryExpression<P> factoryExpression, Predicate predicate) {
        return createQuery(predicate).select(factoryExpression).fetchFirst();
    }

    @Override
    public <P> List<P> findAll(FactoryExpression<P> factoryExpression, Predicate predicate) {
        return createQuery(predicate).select(factoryExpression).fetch();
    }

    @Override
    public <P> List<P> findAll(FactoryExpression<P> factoryExpression, Predicate predicate,
                               Sort sort) {
        return querydsl.applySorting(sort, createQuery(predicate).select(factoryExpression)).fetch();
    }

    @Override
    public <P> Page<P> findAll(FactoryExpression<P> factoryExpression, Predicate predicate,
                               Pageable pageable) {
        JPQLQuery countQuery = createQuery(predicate);
        JPQLQuery<P> query = querydsl.applyPagination(pageable, createQuery(predicate).select(
                factoryExpression));

        Long total = countQuery.fetchCount();
        List<P> content = pageable == null || total > pageable.getOffset() ? query.fetch()
                : Collections.<P>emptyList();
        return new PageImpl<>(content, pageable, total);
    }

}
