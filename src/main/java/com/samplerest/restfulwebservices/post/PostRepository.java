package com.samplerest.restfulwebservices.post;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post_V2,Integer> {
	Optional<Post_V2> findByIdAndUser_id(Integer ID, Integer User_ID);
}
