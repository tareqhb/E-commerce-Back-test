package be.bt.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Table(name="Category")
@Data
//@JsonIgnoreProperties({"products"})
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long category_id;
	private String category_name;
	
	@OneToMany(mappedBy="category")
	private List<Product> products;
	
	public Category(String category_name) {
		this.category_name = category_name;
	}
	public Category() {
		super();
	}
	
	
}
