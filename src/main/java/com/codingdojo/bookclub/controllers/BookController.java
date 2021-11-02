package com.codingdojo.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookServ;
	UserService userServ;
	
	public BookController(UserService userServ) { 
		 this.userServ = userServ; 
	 }

	    
    @RequestMapping("/new/book")
    public String newBook(Model model, @ModelAttribute("book") Book book) {
    	model.addAttribute("book", new Book());
    	List<User> user = userServ.allUsers();
		model.addAttribute("user", user);
		 
        return "/books/newBook.jsp";
    }
	
	@RequestMapping(value = "/Createbook", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			
			return "redirect:/Createbook";
		}
		bookServ.create(book);
		return "redirect:/dashboard";
	}
	
	 @RequestMapping(value="/books/{id}/delete", method=RequestMethod.DELETE)
       public String delete(@PathVariable("id") Long id) {
           bookServ.deleteBook(id);
           return "redirect:/dashboard";
	 }
	 
	 @RequestMapping("/books/{id}")
	    public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
	    	model.addAttribute("book", bookServ.oneBook(id));
	    	
    		Long user_id = (Long) session.getAttribute("user_id");
    		model.addAttribute("user", userServ.findUser(user_id));
	    	
	    	return "/books/show.jsp";
	 }
	 
	 @RequestMapping("/books/{id}/edit")
	    public String editBook(@PathVariable("id") Long id, Model model) {
	        Book book = bookServ.oneBook(id);
	        model.addAttribute("book", book);
	            		
	        return "/books/edit.jsp";
	    }
	    
	    @RequestMapping(value="/books/{id}/edit", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/books/edit.jsp";
	        } else {
	            book = bookServ.updateBook(book);
	            return "redirect:/dashboard";
	        }
	    }

}
