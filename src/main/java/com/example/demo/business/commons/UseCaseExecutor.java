package com.example.demo.business.commons;

import com.example.demo.business.commons.validation.ValidationOrder;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import java.util.HashSet;
import java.util.Set;

@Component
public class UseCaseExecutor {
    private final Validator validator;
    private final AutowireCapableBeanFactory beanFactory;

    public UseCaseExecutor(Validator validator, AutowireCapableBeanFactory beanFactory) {
        this.validator = validator;
        this.beanFactory = beanFactory;
    }

    @Transactional
    public <T> T execute(UseCase<T> usecase) {
        //Injeta dependências definidas com @AutoWired
        beanFactory.autowireBean(usecase);

        //Realiza as validações definidas com as anotações do Javax.validation.
        //O Segundo parâmetro é necessário somente se quiser habilitar as validações
        //secundárias, se quiser usar apenas as primárias não precisaria do segundo parâmetro
        //nem das classes relacionadas.
        Set<ConstraintViolation<Object>> violations = validator.validate(usecase,
                ValidationOrder.class);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<>(violations));
        }

        try {
            return usecase.execute();
        } finally {
            beanFactory.destroyBean(usecase);
        }
    }
}