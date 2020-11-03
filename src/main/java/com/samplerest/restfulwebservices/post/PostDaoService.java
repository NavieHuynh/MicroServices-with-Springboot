package com.samplerest.restfulwebservices.post;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.samplerest.restfulwebservices.post.Post;
import com.samplerest.restfulwebservices.user.User;


@Component
public class PostDaoService {
	
	private static List<Post> posts = new ArrayList<>();
	
	private static int postsCount= 9;
	static {
		posts.add(new Post(1, "This is a post", 2, 1, new Date()));
		posts.add(new Post(2, "This is also post", 3, 1, new Date()));
		posts.add(new Post(3, "This is another post", 1, 1, new Date()));
		posts.add(new Post(4, "This is a persons post", 2, 2, new Date()));
		posts.add(new Post(5, "This is also a persons post", 5, 2, new Date()));
		posts.add(new Post(6, "This is not a post", 6, 2, new Date()));
		posts.add(new Post(7, "This is a post", 6, 3, new Date()));
		posts.add(new Post(8, "This is a post", 2, 3, new Date()));
		posts.add(new Post(9, "This is a post", 3, 3, new Date()));
	}
	public List<Post> findAll(){
		return posts;
	}
	
	public Post save(Post post) {
		if(post.getId()==null) {
			post.setId(++postsCount);
		}
		
		posts.add(post);
		return post;
	};
	
	public List<Post> findUserPosts(int userId){
		List<Post> userPosts = new ArrayList<>();
		for(Post post: posts) {
			if(post.getUserid().equals(userId)) {
				userPosts.add(post);
			}
		}
		return userPosts;
	}
	
	public Post findUserPost(int userId ,int postId) {
		List<Post> posts = findUserPosts(userId);
		for(Post post: posts) {
			if(post.getId().equals(postId)) {
				return post;
			}
		}
		return null;
	};
}


