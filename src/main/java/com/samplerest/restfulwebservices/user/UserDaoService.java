package com.samplerest.restfulwebservices.user;

import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int usersCount= 3;
	static {
		users.add(new User("yeaha","Adam", 1, new Date()));
		users.add(new User("Person","Second", 2, new Date()));
		users.add(new User("Third","Person", 3, new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		if(user.getBirthDate()==null) {
			user.setBirthDate(new Date());
		}
		users.add(user);
		return user;
	};
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	};
	public User deleteById(int userId) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() ==userId) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
}
