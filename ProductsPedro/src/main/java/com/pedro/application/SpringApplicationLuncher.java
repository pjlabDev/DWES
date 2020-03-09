/**
 * 
 */
package com.pedro.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedro.controller.HomeController;
/**
 * @author pedro
 *
 */
@SpringBootApplication
public class SpringApplicationLuncher {

	public static void main(String[] args) {
		SpringApplication.run(HomeController.class, args);
	}

}
