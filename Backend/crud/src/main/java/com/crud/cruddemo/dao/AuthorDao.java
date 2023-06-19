package com.crud.cruddemo.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.crud.cruddemo.model.Author;


//CrudRepository is the parent class that has all spring methods
//We can also extend JPARepository which is the child class of CrudRepository
public interface AuthorDao extends CrudRepository<Author, Integer>{

	public Author findByAuthorName(String authorName);
	
	public List<Author> findByAuthorNameOrBookTitle(String authorName, String bookTitle);
}
