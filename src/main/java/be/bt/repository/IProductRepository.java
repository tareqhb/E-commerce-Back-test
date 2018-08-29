package be.bt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.bt.domain.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
	
		
}
