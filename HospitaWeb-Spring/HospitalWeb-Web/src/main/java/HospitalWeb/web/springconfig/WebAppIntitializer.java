/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.web.springconfig;



import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 *
 * @author Жека
 */
public class WebAppIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
//        @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
////        //create the root Spring application context
////        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
////        rootContext.register(ApplicationConfig.class, SecurityConfig.class);
//// 
////        servletContext.addListener(new ContextLoaderListener(rootContext));
//// 
////        //Create the dispatcher servlet's Spring application context
////        AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
////        servletAppContext.register(MVCConfig.class);
//// 
////        DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
////        // throw NoHandlerFoundException to controller ExceptionHandler.class. Used for <error-page> analogue
////        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
// 
////        //register and map the dispatcher servlet
////        //note Dispatcher servlet with constructor arguments
////        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
////        dispatcher.setLoadOnStartup(1);
////        dispatcher.addMapping("/");
// 
//        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
//        encodingFilter.setInitParameter("encoding", "UTF-8");
//        encodingFilter.setInitParameter("forceEncoding", "true");
//        encodingFilter.addMappingForUrlPatterns(null, true, "/*");
// 
//    }
    @Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {WebConfig.class}; // We dont need any special servlet config yet.
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
    
}
