package pl.coderslab.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;

@Configuration
public class DbConfig {
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean entityManagerFactory
                = new LocalEntityManagerFactoryBean();
        entityManagerFactory.setPersistenceUnitName("bookstorePersistenceUnit"); // nazwa bazy za pliku persistence.xml
        return entityManagerFactory;                                            //  <persistence-unit name="bookstorePersistenceUnit">
    }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
