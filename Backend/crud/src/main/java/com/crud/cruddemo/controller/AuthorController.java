package com.crud.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.cruddemo.model.Author;
import com.crud.cruddemo.service.AuthorService;

@RestController
@RequestMapping("author")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	//AuthorService authorService=new AuthorServiceImpl();
	
	@PostMapping
	public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
		return new ResponseEntity<Author>(authorService.saveAuthor(author),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Author>> getAllAuthors(){
		return new ResponseEntity<List<Author>>(authorService.getAllAuthors(),HttpStatus.FOUND);
	}
	
	@GetMapping("{authorName}")
	public ResponseEntity<Author> getAuthorByName( @PathVariable String authorName){
		return new ResponseEntity<Author>(authorService.getAuthorByName(authorName),HttpStatus.FOUND);
	}
	
	@GetMapping("{authorName}/{bookTitle}")
	public ResponseEntity<List<Author>> getAuthorsByNameOrTitle(@PathVariable String authorName,@PathVariable String bookTitle){
		List<Author> authors=authorService.findByAuthorNameOrBookTitle(authorName, bookTitle);
		return new ResponseEntity<List<Author>>(authors,HttpStatus.FOUND);
		
	}
	
	@PutMapping("{authorId}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable int authorId){
		return new ResponseEntity<Author>(authorService.updateAuthor(author,authorId),HttpStatus.CREATED);
	}
	
	@DeleteMapping("{authorId}")
	public ResponseEntity<String> deleteAuthor(@PathVariable int authorId){
		String status=authorService.deleteAuthor(authorId);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	
}
