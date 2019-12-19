package com.heliohdd.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heliohdd.workshopmongo.domain.Post;
import com.heliohdd.workshopmongo.repository.PostRepository;
import com.heliohdd.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
	}
	
//	public List<Post> findByTitle(String text){				//	Substituído por "searchTitle" abaixo
//		return repo.findByTitleContainingIgnoreCase(text);
//	}

	public List<Post> searchTitle(String text){
		return repo.searchTitle(text);
	}

	
}
