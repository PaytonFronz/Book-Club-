package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repositories.BookRepository;

    
@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepo;
    
    	public List<Book> allBooks() {
    		return bookRepo.findAll();
    	}


    	public Book create(Book book) {
    		return bookRepo.save(book);
    	}

    	public Book oneBook(Long id) {
    		Optional<Book> optionalBook = bookRepo.findById(id);
    		if (optionalBook.isPresent()) {
    			return optionalBook.get();
			} else {
				return null;
			}
    	}

    	public Book updateBook(Book book) {
    		return bookRepo.save(book);
    	}


    		public void deleteBook(Long id) {
    			bookRepo.deleteById(id);
    	}

    
}