package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	EmployeeService employeeService;

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			System.out.println("\nDeleting employee....");
			employeeService.deleteEmployees();

			System.out.println("Adding employees....\n");
			employeeService.addEmployee(new Employee("Juliana", "Castro", "Salesman", 63000.00, LocalDate.of(2003, 02, 28)));
			employeeService.addEmployee(new Employee("Jorge", "Useche", "Substitute", 43000.00,LocalDate.of(2003,10,12)));


			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));

		};
	}


}
