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

import be.bt.domain.Category;
import be.bt.domain.Product;
import be.bt.repository.ICategoryRepository;
@RestController
@RequestMapping("/categories")
@CrossOrigin(origins="*")
public class CategoryRestController {
	 @Autowired
	  private ICategoryRepository repository;
	  @GetMapping("")
	  public List<Category> getAllCategories()
	  {
		  return repository.findAll();
	  }
	  @GetMapping("{id}")
	  public ResponseEntity<Category> findById(@PathVariable Long id)
	  {
		  Optional<Category> res=repository.findById(id);
		  return (res.isPresent()) ? new ResponseEntity<>(res.get(),HttpStatus.OK):
			  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	
	  @PostMapping
	  public ResponseEntity<Category> addCategory(@RequestBody Category c)
	  {
		  Category res=repository.save(c);
		  return(res!=null) ? new ResponseEntity<>(res,HttpStatus.CREATED):new ResponseEntity<>(null,HttpStatus.CONFLICT);
	  }
	  @DeleteMapping("{id}")
	  public ResponseEntity<Category> deleteCategory(@PathVariable Long id)
	  {
		 Optional<Category> category=repository.findById(id);
		 if(!category.isPresent())
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 else 
		 {
			 repository.delete(category.get());
			 return new ResponseEntity<>(HttpStatus.ACCEPTED);
			 
		 }
	  }
	  @PutMapping("")
	  public ResponseEntity<Category> updateCategory(@RequestBody Category c)
	  {
		  Category res=repository.save(c);
		  return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
	  }
	}
