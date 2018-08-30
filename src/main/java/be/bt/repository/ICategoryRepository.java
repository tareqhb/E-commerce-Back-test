package be.bt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.bt.domain.Category;

public interface ICategoryRepository extends JpaRepository<Category,Long> {


}
