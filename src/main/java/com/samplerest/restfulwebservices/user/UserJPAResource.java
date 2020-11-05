package com.samplerest.restfulwebservices.user;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.samplerest.restfulwebservices.post.Post_V2;
import com.samplerest.restfulwebservices.post.PostNotFoundException;
import com.samplerest.restfulwebservices.post.PostRepository;
import com.samplerest.restfulwebservices.post.Post_V1;

@RestController
public class UserJPAResource {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	private Optional<User> findUser(int id) {
		Optional<User> findOne = userRepository.findById(id);
		if(findOne==null)
			throw new UserNotFoundException("id-"+id);
		return findOne;
	}
	
	private Optional<Post_V2> findPostByPostID(int userId, int postId) {
		Optional<Post_V2> findPost = postRepository.findByIdAndUser_id(postId, userId);
		
		if(findPost==null)
			throw new PostNotFoundException("userId-"+userId+" postId-"+postId);
		
		return findPost;
		
	}
//	
	@GetMapping(path="/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}

	@GetMapping(path="/jpa/users/{userId}")
	public EntityModel<Optional<User>> retrieveUser(@PathVariable int userId)
	{
		Optional<User> user = findUser(userId);
		EntityModel<Optional<User>> resource = EntityModel.of(user);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	@DeleteMapping(path="/jpa/users/{userId}")
	public void deleteUser(@PathVariable int userId)
	{	
		userRepository.deleteById(userId);

	}
	@PostMapping(path="/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/jpa/users/{userId}/posts")
	public List<Post_V2> retrieveUserPosts(@PathVariable int userId) {
		Optional<User> userOptional = findUser(userId);
		
		return userOptional.get().getPosts();
	}
	
	@GetMapping(path="/jpa/users/{userId}/posts/{postId}")
	public EntityModel<Optional<Post_V2>> retrieveUserPost(@PathVariable int userId, @PathVariable int postId) {
		
		Optional<Post_V2> post = findPostByPostID(userId,postId);
		EntityModel<Optional<Post_V2>> resource = EntityModel.of(post);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveUserPosts(userId));
		
		resource.add(linkTo.withRel("all-users-post"));
		
		return resource;
	}
	
	@PostMapping(path="/jpa/users/{userId}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int userId, @RequestBody Post_V2 post){
		Optional<User> userOptional = findUser(userId);
		
		User user = userOptional.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId())
				.toUri();
			return ResponseEntity.created(location).build();
		
	}
}
