package com.YE.rest.practice.practice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
 import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
 import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Exception.UserNotFoundException;

@RestController
public class UserResource{
	
	@Autowired
	UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		return service.findAll();
	}
	 @GetMapping("/users/{id}")
	 public Resource<User> retrieveUser(@PathVariable int id) {
	 User user = service.findOne(id);
	 if (user== null)
	 throw new UserNotFoundException("id-" + id);
		Resource<User> resource = new Resource<User>(user);
		//instaead of hard coding links we can send link from so that any change is refleced in link passed
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers()); 
		resource.add(linkTo.withRel("all-users"));
	return resource;
}
	@PostMapping(path="/users")
	public ResponseEntity<Object> CreateUser(@Valid @RequestBody User user)
	{
		User savedUser=service.save(user);
		URI location=ServletUriComponentsBuilder//used to get current request/route information
		.fromCurrentRequest()  //get current request info
		.path("/{id") //append id to it
		.buildAndExpand(savedUser.getId())//replace id with current user to it 
		.toUri();//retrieve cal uri
		return ResponseEntity.created(location).build();
		//best to status as result
	}
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id)
	{
		User user=service.deletebyId(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		return user;
	}

}
