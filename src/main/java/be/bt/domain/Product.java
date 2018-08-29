package be.bt.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
@Entity
@Table(name="Product")
@Data
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

}
