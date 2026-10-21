package com.durgasoft.spring_boot_container;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starts a Spring Boot servlet application and demonstrates container inspection.
 * <p>The application prints bean definition names and their count, retrieves
 * {@link EmployeeService}, checks its availability and singleton scope, and
 * reads the configured server port from the Spring environment.
 * <p>Component scanning includes this package and its subpackages.
 */
@SpringBootApplication
public class SpringBootContainerApplication {

	/** Service supplied to the application bean through constructor injection. */
	private final EmployeeService employeeService;

	/**
	 * Creates the application bean with its required service dependency.
	 * <p>Spring uses this sole constructor without an explicit autowiring annotation.
	 * The static {@link #main(String[])} method demonstrates a separate bean lookup.
	 *
	 * @param employeeService the service resolved by the container
	 */
	SpringBootContainerApplication(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * Starts the context and embedded server, then prints the container diagnostics.
	 * <p>The definition count describes registered definitions, not the number of
	 * instantiated objects. The port property is configuration, not a query for
	 * the server's actual bound port. The context stays open to serve requests.
	 *
	 * @param args command-line arguments passed to Spring Boot
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootContainerApplication.class, args);
		// The MVC starter enables servlet web application startup.

		System.out.println("Count of Bean " + applicationContext.getBeanDefinitionCount());

		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println("Bean Name :" + beanName);
		}
//		EmployeeService employeeService =  applicationContext.getBean(EmployeeService.class);
		
//		EmployeeService employeeService = (EmployeeService) applicationContext.getBean("employeeService");
		
		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);

		boolean isAvialable = applicationContext.containsBean("employeeService");
		System.out.println("Bean is avialable :" + isAvialable);

		Environment environment = applicationContext.getEnvironment();
		System.out.println("Server Port :" + environment.getProperty("server.port"));
		
		
		boolean isSingleTon= applicationContext.isSingleton("employeeService");
		System.out.println("is this singleton class :"+isSingleTon);
		

		employeeService.display();

	}

}
