package be.bt.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Table(name="Product")
@Data
@JsonIgnoreProperties({"category"})
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long product_id;
private String product_name;
private String product_description;
private BigDecimal product_price_sel;
private BigDecimal product_price_buy;
private String image1;
private String image2;
private String image3;
@ManyToOne
private Category category;
public Product(String product_name, String product_description, BigDecimal product_price_sel,
		BigDecimal product_price_buy, String image1, String image2, String image3, Category category) {
	super();
	this.product_name = product_name;
	this.product_description = product_description;
	this.product_price_sel = product_price_sel;
	this.product_price_buy = product_price_buy;
	this.image1 = image1;
	this.image2 = image2;
	this.image3 = image3;
	this.category = category;
}
public Product() {
	super();
}


}
