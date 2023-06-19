package com.crud.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.cruddemo.dao.AuthorDao;
import com.crud.cruddemo.exception.AuthorAlreadyExists;
import com.crud.cruddemo.exception.UnableToDelete;
import com.crud.cruddemo.model.Author;


@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	AuthorDao authordao;

	@Override
	public Author saveAuthor(Author author) {
		//author.setAuthorId(new Random().nextInt(100));
		
		Author found=getAuthorById(author.getAuthorId());
		
		if(found!=null)
		throw new AuthorAlreadyExists("author already exists");
		return authordao.save(author);

	}
	public Author getAuthorById(int authorId) {
		java.util.Optional<Author> author=authordao.findById(authorId);
		if(author.isPresent()) {
			return author.get();
		}
		return null;
	}
	
	public List<Author> getAllAuthors() {
		return (List<Author>) authordao.findAll();
	}
	
	public Author getAuthorByName(String authorName) {
		return authordao.findByAuthorName(authorName);
	}

	@Override
	public List<Author> findByAuthorNameOrBookTitle(String authorName, String bookTitle) {
		return authordao.findByAuthorNameOrBookTitle(authorName, bookTitle);
	}
	
	public Author updateAuthor(Author author,int authorId) {
		return authordao.save(author);
	}

	public String deleteAuthor(int authorId) {
		
		java.util.Optional<Author> author=authordao.findById(authorId);
		if(author.isPresent()) {
			authordao.deleteById(authorId);
			return "Author Deleted";
		}
		throw new UnableToDelete("ID Not Found/Unable to Delete");
		//return null;
		
	}
}
