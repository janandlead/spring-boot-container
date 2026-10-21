package com.durgasoft.spring_boot_container;

import org.springframework.stereotype.Service;

/**
 * Simple service used to demonstrate Spring bean registration and lookup.
 * <p>Component scanning registers this class as {@code employeeService} with
 * the default singleton scope: one instance per bean definition per container.
 */
@Service
public class EmployeeService {
	
	/**
	 * Prints {@code EmployeeService -> display()} to standard output to show
	 * that the service obtained from the container can be invoked.
	 */
	public void display() {
		System.out.println("EmployeeService -> display()");
	}

}
