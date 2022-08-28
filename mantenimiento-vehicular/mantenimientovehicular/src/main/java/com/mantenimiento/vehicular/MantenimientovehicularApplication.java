package com.mantenimiento.vehicular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MantenimientovehicularApplication implements CommandLineRunner{
		
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(MantenimientovehicularApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		String password="vanesa";
		for(int i=0;i<2;i++){
			String bcryptPassword=passwordEncoder.encode(password);
			System.out.println(bcryptPassword);
		}
	}


}
