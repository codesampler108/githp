package com.rk.jaxws.config;

import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Binding;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.endpoint.ServerImpl;
import org.apache.cxf.endpoint.ServerRegistry;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.jaxws.support.JaxWsServiceFactoryBean;
import org.apache.cxf.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.rk.jaxws.cxfanno.interceptor.in.PreInvokeInterceptor;
import com.rk.jaxws.cxfanno.interceptor.in.PreStreamInterceptor;
import com.rk.jaxws.cxfanno.interceptor.in.PrintInterceptorsAndMessageFormats;
import com.rk.jaxws.cxfanno.interceptor.in.Readnterceptor;
import com.rk.jaxws.cxfanno.interceptor.out.SetupInterceptor;
import com.rk.jaxws.cxfanno.serviceimpl.CalculatorWS;

/*CAUTION - don't forget context scanning. otherwise no service beans will be available. You need too add xlmns:context, and xsi:schemaLocation */
@Configuration
@ComponentScan("com.rk.jaxws.cxfanno")
@ImportResource({ "classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-servlet.xml",
		"classpath:META-INF/cxf/cxf-extension-jaxws.xml", "classpath:jaxwsconfig/beans.xml" })
public class CalculatorAppConfig {

	@Autowired
	PreInvokeInterceptor preInvokeInterceptor;

	@Autowired
	PreStreamInterceptor preStreamInterceptor;

	@Autowired
	PrintInterceptorsAndMessageFormats printInterceptorsAndMessageFormats;

	@Autowired
	SetupInterceptor setupInterceptor;

	/*
	 * Interceptors would be called as per apache cxf pipeline. below sequence does
	 * not matter
	 */
	@Bean
	public Bus getDefaultBus() {
		Bus defaultBus = BusFactory.getDefaultBus();
		System.out.println("bus:" + defaultBus.toString());
		defaultBus.getInInterceptors().add(new Readnterceptor());
		defaultBus.getInInterceptors().add(preInvokeInterceptor);
		defaultBus.getInInterceptors().add(preStreamInterceptor);
		defaultBus.getInInterceptors().add(printInterceptorsAndMessageFormats);
		defaultBus.getInInterceptors().add(setupInterceptor);
		return defaultBus;
	}

	@Bean
	public String testBean() {
		System.out.println("created testBean");
		return "TestBean";
	}

	/*
	 * COULD NOT GET THIS WORKING. had to restore beans.xml for implementor and
	 * address mapping
	 */

	@Autowired
	CalculatorWS calculatorWS;

	/* This code does not work. This end-point is added using jaxws:endpoint configuration in beans.xml */
	@Bean
	public EndpointImpl calculator() {
		Bus defaultBus = BusFactory.getDefaultBus();

		System.out.println("bus:" + defaultBus.toString());
		EndpointImpl endPoint = new EndpointImpl(defaultBus, calculatorWS);

		endPoint.setAddress("/services/calculator");
		endPoint.setServiceName(new QName("Calculator"));
		endPoint.setBus(defaultBus);
		endPoint.publish();

		/*
		 * ServerRegistry serverRegistry =
		 * defaultBus.getExtension(ServerRegistry.class); servers =
		 * serverRegistry.getServers();
		 * servers.forEach(x->System.out.println(x.getEndpoint()));
		 */

		/*
		 * JaxWsServerFactoryBean serverFactory = endPoint.getServerFactory();
		 * JaxWsServiceFactoryBean jaxWsServiceFactory =
		 * serverFactory.getJaxWsServiceFactory(); Service service =
		 * jaxWsServiceFactory.create(); Map<QName, Endpoint> endpoints =
		 * service.getEndpoints(); endpoints.keySet().forEach(x ->
		 * System.out.println(x.toString()));
		 */
		return endPoint;
	}

}
