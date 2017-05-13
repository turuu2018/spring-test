package mn.turuu.springtest.config;

import java.util.logging.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 *
 * @author PDBD
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"mn.turuu.springtest.controller"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private static final Logger LOGGER = Logger.getLogger(WebMvcConfig.class.getName());

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        LOGGER.info("[Spring test] Adding interceptors...");
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang"); // default paramName = locale
        registry.addInterceptor(localeChangeInterceptor);

        //registry.addInterceptor(viewNameInModelInterceptor);
        //registry.addInterceptor(deviceResolverHandlerInterceptor());
    }*/

    @Bean
    public TilesConfigurer tilesConfigurer() {
        LOGGER.info("[Spring test] Configuring tiles...");
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/**/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
        LOGGER.info("[Spring test] Configuring tiles view resolver...");
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        tilesViewResolver.setOrder(0);
        return tilesViewResolver;
    }

    @Bean
    public ResourceBundleViewResolver xlsViewResolver() {
        LOGGER.info("[Spring test] Configuring resource bundle view resolver...");
        ResourceBundleViewResolver resourceBundleViewResolver = new ResourceBundleViewResolver();
        resourceBundleViewResolver.setBasename("views");
        resourceBundleViewResolver.setOrder(1);
        return resourceBundleViewResolver;
    }

    @Bean
    public ViewResolver viewResolver() {
        LOGGER.info("[Spring test] Configuring view resolver...");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(2);
        return viewResolver;
    }

    /*@Bean
    public MessageSource messageSource() {
        LOGGER.info("[Spring test] Configuring message source...");
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/messages/messages");
        messageSource.setCacheSeconds(0);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOGGER.info("[Spring test] Adding resource handlers...");

        registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCachePeriod(604800); //secundeer 7 honog cach
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }*/
}
