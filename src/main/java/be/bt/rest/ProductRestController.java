package be.bt.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.bt.domain.Product;
import be.bt.repository.ICategoryRepository;
import be.bt.repository.IProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins="*")
public class ProductRestController {
  @Autowired
  private IProductRepository repository;
  @Autowired
  private ICategoryRepository repositoryCategorie;
  @GetMapping("")
  public List<Product> getAllProducts()
  {
	  return repository.findAll();
  }
  @GetMapping("{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id)
  {
	  Optional<Product> res=repository.findById(id);
	  return (res.isPresent()) ? new ResponseEntity<>(res.get(),HttpStatus.OK):
		  new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  @PostMapping
  public ResponseEntity<Product> addProduct(@RequestBody Product c)
  {
	   c.setCategory(repositoryCategorie.findById((long)1).get());
	   c.getCategory().getProducts().add(c);
	  repositoryCategorie.save(c.getCategory());
	  Product res=repository.save(c);
	  return(res!=null) ? new ResponseEntity<>(res,HttpStatus.CREATED):new ResponseEntity<>(null,HttpStatus.CONFLICT);
  }
  @DeleteMapping("{id}")
  public ResponseEntity<Product> deleteProduct(@PathVariable Long id)
  {
	 Optional<Product> product=repository.findById(id);
	 if(!product.isPresent())
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 else 
	 {
		 repository.delete(product.get());
		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
		 
	 }
  }
  @PutMapping("")
  public ResponseEntity<Product> updateProduct(@RequestBody Product c)
  {
	  Product res=repository.save(c);
	  return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
  }
}
