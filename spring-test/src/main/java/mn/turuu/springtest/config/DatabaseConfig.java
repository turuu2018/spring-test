package mn.turuu.springtest.config;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.support.OpenSessionInterceptor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author PDBD
 */
@Configuration
@EnableTransactionManagement
//@PropertySource("classpath:properties/config_${spring.profiles.active:development}.properties")
public class DatabaseConfig {

    private static final Logger LOGGER = Logger.getLogger(DatabaseConfig.class.getName());

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    private final String driver = "com.mysql.jdbc.Driver";

    private final String dialect = "org.hibernate.dialect.MySQLDialect";

    @Bean
    public DataSource dataSource() {
        LOGGER.log(Level.INFO, "Creating data source: {0} with {1}", new String[]{jdbcUrl, driver});

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    private Properties hibernateProperties() {
        LOGGER.log(Level.INFO, "Creating hibernate properties: {0}", new String[]{ dialect});

        Properties props = new Properties();
        props.put("hibernate.connection.CharSet", "utf8");
        props.put("hibernate.connection.characterEncoding", "utf8");
        props.put("hibernate.connection.useUnicode", true);
        props.put("hibernate.dialect", dialect);
        props.put("hibernate.bytecode.use_reflection_optimizer", true);
        props.put("hibernate.connection.driver_class", driver);
        props.put("hibernate.c3p0.min_size", 2);
        props.put("hibernate.c3p0.max_size", 20);
        props.put("hibernate.c3p0.max_statements", 50);
        props.put("hibernate.c3p0.timeout", 1800);
        props.put("hibernate.c3p0.idle_test_periods", 900);
        return props;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LOGGER.log(Level.INFO, "Creating session factory");

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"mn.turuu.springtest.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public OpenSessionInterceptor hibernateInterceptor(SessionFactory sessionFactory) {
        LOGGER.log(Level.INFO, "Creating hibernate open session interceptor");
        OpenSessionInterceptor openSesssionInterceptor = new OpenSessionInterceptor();
        openSesssionInterceptor.setSessionFactory(sessionFactory);
        return openSesssionInterceptor;
    }
}
