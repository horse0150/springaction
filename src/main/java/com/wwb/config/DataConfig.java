package com.wwb.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {"com.wwb.dao"})
public class DataConfig {

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spring-boot?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&rewriteBatchedStatements=TRUE");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setInitialSize(10);
        dataSource.setMaxActive(100);
        dataSource.setMinIdle(10);
        dataSource.setMaxWait(60000);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(30000);
        dataSource.setValidationQuery("select 1 from dual");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        return dataSource;
    }

    /**
     * JdbcTemplate
     * @param dataSource
     * @return
     */
    /*@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }*/


    /**
     * 使用hibernate
     * @param dataSource
     * @return
     */
    /*@Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan(new String[]{"com.wwb.model"});
        Properties props = new Properties();
        props.setProperty("dialect","org.hibernate.dialect.MySQL57Dialect");
        factoryBean.setHibernateProperties(props);
        return factoryBean;
    }*/


    /**
     * 定义事务管理bean  子类中使用jpa，该处暂时屏蔽掉
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

    /**
     * 捕获有@Repository注解类的异常，并以spring非检查型的数据访问异常
     * @return
     */
    @Bean
    public BeanPostProcessor persistenceTranslation(){
        return new PersistenceAnnotationBeanPostProcessor();
    }

    /**
     * 是spring理解@PersistenceUnit 和 @PersistenceContext
     * @return
     */
    @Bean
    public PersistenceAnnotationBeanPostProcessor paPostProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL57Dialect");
        return adapter;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean manager = new LocalContainerEntityManagerFactoryBean();
        manager.setDataSource(dataSource);
        manager.setJpaVendorAdapter(jpaVendorAdapter);
        manager.setPackagesToScan("com.wwb.model");
        return manager;
    }
}
