package mn.turuu.springtest.config;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author PDBD
 */
public class AppInitializer implements WebApplicationInitializer {

    private static final Logger LOGGER = Logger.getLogger(AppInitializer.class.getName());

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOGGER.info("Starting app..");

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.getEnvironment().setDefaultProfiles("development");
        if (rootContext.getEnvironment().getActiveProfiles().length > 0) {
            for (String mode : rootContext.getEnvironment().getActiveProfiles()) {
                LOGGER.log(Level.INFO, "[Spring test] Running mode: {0}", mode);
            }
        } else {
            for (String mode : rootContext.getEnvironment().getDefaultProfiles()) {
                LOGGER.log(Level.INFO, "[Spring test] Running mode: {0}", mode);
            }
        }

        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.setInitParameter("defaultHtmlEscape", "true"); // escape html in form tags

        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(WebMvcConfig.class);

        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");

        FilterRegistration.Dynamic hibernateFilter = servletContext.addFilter("hibernateFilter", new OpenSessionInViewFilter());
        hibernateFilter.setInitParameter("sessionFactoryBeanName", "sessionFactory");
        hibernateFilter.addMappingForUrlPatterns(null, true, "/*");

        ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(rootContext));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}
