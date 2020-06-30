package com.example.demo.config;

import com.example.demo.business.commons.UseCaseExecutor;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public abstract class AbstractSpringIT {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    protected UseCaseExecutor executor;

    @Autowired
    protected PlatformTransactionManager transactionManager;

    protected Session session;

    private TransactionStatus transaction;

    @Before()
    public void before() throws IOException {
        transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
        session = (Session) entityManager.getDelegate();

        //importa script com nome do teste, se existir
        ClassPathResource file = new ClassPathResource("seed/" + this.getClass().getSimpleName().
                replaceAll("\\.", "/") + ".sql");
        if (file.exists()) {
            ScriptRunner scriptRunner = new ScriptRunner(file.getFile(), "UTF-8");
            scriptRunner.run(entityManager);
        }
    }

    @After
    public void after() {
        entityManager.flush();
        transactionManager.rollback(transaction);
    }

}
