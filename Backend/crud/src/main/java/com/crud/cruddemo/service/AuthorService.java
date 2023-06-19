package com.crud.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.cruddemo.model.Author;

@Service
public interface AuthorService {
	
	public Author saveAuthor(Author author);
	public Author getAuthorByName(String authorName);
	public List<Author> getAllAuthors();

	public List<Author> findByAuthorNameOrBookTitle(String authorName, String bookTitle);

	public Author updateAuthor(Author author,int authorId);
	
	public String deleteAuthor(int authorid);
	
	
}
