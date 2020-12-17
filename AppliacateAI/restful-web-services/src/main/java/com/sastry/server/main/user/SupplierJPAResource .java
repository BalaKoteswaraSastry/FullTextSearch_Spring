package com.sastry.server.main.user;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ProductMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
public class SupplierJPAResource 
{
@Autowired
private SupplierDaoService service;
@Autowired
private SupplierRepository userRepository;

//Retrieving all user from the userRepository
@GetMapping("/jpa/users")
public List<Supplier> retriveAllSuppliers()
{
return userRepository.findAll();
}

/*
//retrieves a specific user detail
@GetMapping("/jpa/users/{id}")
public Supplier retriveSupplier(@PathVariable int id)
{
Supplier user= service.findOne(id);
if(user==null)
//runtime exception
throw new SupplierNotFoundException("id: "+ id);
return user;
}
*/

@GetMapping("/jpa/users/{id}")
public Resource<Supplier> retriveSupplier(@PathVariable int id)
{
Optional<Supplier> user= userRepository.findById(id);
if(!user.isPresent())
//runtime exception
throw new SupplierNotFoundException("id: "+ id);
//"all-users", SERVER_PATH + "/users"
//retrieveAllSuppliers
Resource<Supplier> resource=new Resource<Supplier>(user.get());	//constructor of Resource class
//add link to retrieve all the users
ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retriveAllSuppliers());
resource.add(linkTo.withRel("all-users"));
return resource;
}

//method that delete a user resource
@DeleteMapping("/jpa/users/{id}")
public void deleteSupplier(@PathVariable int id)
{
userRepository.deleteById(id);
}
//method that posts a new user detail and returns the status of the user resource
@ProductMapping("/jpa/users")
public ResponseEntity<Object> createSupplier(@Valid @RequestBody Supplier user)	
{
Supplier sevedSupplier=service.save(user);	
URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedSupplier.getId()).toUri();
return ResponseEntity.created(location).build();
}
//Retrieving all posts of a specific user
@GetMapping("/jpa/users/{id}/posts")
public List<Product> retriveAllSuppliers(@PathVariable int id)
{
Optional<Supplier> userOptional= userRepository.findById(id);
if(!userOptional.isPresent())
{
throw new SupplierNotFoundException("id: "+ id);
}
return userOptional.get().getProducts();
}
}
