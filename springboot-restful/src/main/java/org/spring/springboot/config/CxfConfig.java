package org.spring.springboot.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.spring.springboot.service.cxf.CommonService;
import org.spring.springboot.service.cxf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

/**
 * Created by Peng.lv on 2017/12/13.
 */

@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;

    @Autowired
    private CommonService commonService;

    @Autowired
    public UserService userService;

    @Bean
    public ServletRegistrationBean createCxfServlet() {
        CXFServlet cxfServlet = new CXFServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(cxfServlet, "/ws/*");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    /** JAX-WS **/
    @Bean
    public Endpoint commonServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, commonService);
        endpoint.publish("/commonService");
        return endpoint;
    }

    @Bean
    public Endpoint userServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, userService);
        endpoint.publish("/userService");
        SOAPBinding binding = (SOAPBinding)endpoint.getBinding();
        binding.setMTOMEnabled(true);
        return endpoint;
    }
}