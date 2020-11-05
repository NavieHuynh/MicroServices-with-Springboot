package com.samplerest.restfulwebservices.user;


import java.net.URI;
import java.util.List;

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

import com.samplerest.restfulwebservices.post.Post_V1;
import com.samplerest.restfulwebservices.post.PostDaoService;
import com.samplerest.restfulwebservices.post.PostNotFoundException;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userService;
	
	@Autowired
	private PostDaoService postService;
	
	private User findUser(int id) {
		User findOne = userService.findOne(id);
		if(findOne==null)
			throw new UserNotFoundException("id-"+id);
		return findOne;
	}
	
	private Post_V1 findPost(int userId, int postId) {
		Post_V1 findPost = postService.findUserPost(userId, postId);
		
		if(findPost==null)
			throw new PostNotFoundException("userId-"+userId+" postId-"+postId);
		
		return findPost;
		
	}
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return userService.findAll();
	}

	@GetMapping(path="/users/{userId}")
	public EntityModel<User> retrieveUser(@PathVariable int userId)
	{
		User user = findUser(userId);
		EntityModel<User> resource = EntityModel.of(user);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	@DeleteMapping(path="/users/{userId}")
	public void deleteUser(@PathVariable int userId)
	{	
		User user = userService.deleteById(userId);
		
		if(user==null)
			throw new UserNotFoundException("userId-" + userId);
	}
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/users/{userId}/posts")
	public List<Post_V1> retrieveUserPosts(@PathVariable int userId) {
		User user = findUser(userId);
		return postService.findUserPosts(user.getId());
	}
	
	@GetMapping(path="/users/{userId}/posts/{postId}")
	public Post_V1 retrieveUserPost(@PathVariable int userId, @PathVariable int postId) {
		User user = findUser(userId);
		return findPost(user.getId(),postId);
	}
	
	@PostMapping(path="/users/{userId}/posts")
	public ResponseEntity<Object> createPost(@RequestBody Post_V1 post){
		Post_V1 savedPost = postService.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
			return ResponseEntity.created(location).build();
		
	}
}
