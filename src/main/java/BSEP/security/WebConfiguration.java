package BSEP.security;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebConfiguration {

	//https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/
	@RequestMapping(
			value = "/h2",
			method = RequestMethod.GET)
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/h2");
        return registrationBean;
    }
}
