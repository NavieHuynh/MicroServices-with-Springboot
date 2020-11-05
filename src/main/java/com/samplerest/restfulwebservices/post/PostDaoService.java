package com.samplerest.restfulwebservices.post;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.samplerest.restfulwebservices.post.Post_V1;
import com.samplerest.restfulwebservices.user.User;


@Component
public class PostDaoService {
	
	private static List<Post_V1> posts = new ArrayList<>();
	
	private static int postsCount= 9;
	static {
		posts.add(new Post_V1(1, "This is a post", 2, 1, new Date()));
		posts.add(new Post_V1(2, "This is also post", 3, 1, new Date()));
		posts.add(new Post_V1(3, "This is another post", 1, 1, new Date()));
		posts.add(new Post_V1(4, "This is a persons post", 2, 2, new Date()));
		posts.add(new Post_V1(5, "This is also a persons post", 5, 2, new Date()));
		posts.add(new Post_V1(6, "This is not a post", 6, 2, new Date()));
		posts.add(new Post_V1(7, "This is a post", 6, 3, new Date()));
		posts.add(new Post_V1(8, "This is a post", 2, 3, new Date()));
		posts.add(new Post_V1(9, "This is a post", 3, 3, new Date()));
	}
	public List<Post_V1> findAll(){
		return posts;
	}
	
	public Post_V1 save(Post_V1 post) {
		if(post.getId()==null) {
			post.setId(++postsCount);
		}
		
		posts.add(post);
		return post;
	};
	
	public List<Post_V1> findUserPosts(int userId){
		List<Post_V1> userPosts = new ArrayList<>();
		for(Post_V1 post: posts) {
			if(post.getUserid().equals(userId)) {
				userPosts.add(post);
			}
		}
		return userPosts;
	}
	
	public Post_V1 findUserPost(int userId ,int postId) {
		List<Post_V1> posts = findUserPosts(userId);
		for(Post_V1 post: posts) {
			if(post.getId().equals(postId)) {
				return post;
			}
		}
		return null;
	};
}


