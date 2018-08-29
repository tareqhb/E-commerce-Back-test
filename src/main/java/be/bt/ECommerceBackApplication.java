package be.bt;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.bt.domain.Product;

import be.bt.repository.IProductRepository;

@SpringBootApplication
public class ECommerceBackApplication {
	@Autowired
	private IProductRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(ECommerceBackApplication.class, args);
	Product dd= new Product();

	}
	@Bean
	public 	CommandLineRunner runIt()
	{
	return args ->{
	//		repo.save(ss);
			repo.findAll().forEach(System.out :: println);
		};
	}
}
