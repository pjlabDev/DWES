/**
 * 
 */
package com.pedro.application;


import org.springframework.boot.SpringApplication;

import com.pedro.controller.HomeController;
/**
 * @author usuario
 *
 */
public class SpringApplicationLuncher {

	public static void main(String[] args) {
		SpringApplication.run(HomeController.class, args);
	}

}
