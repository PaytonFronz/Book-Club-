package com.codingdojo.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;
    
@Controller
public class HomeController {
    
    @Autowired
    private UserService userServ;
    BookService bookServ;
    
    public HomeController(BookService bookServ) { 
		 
		 this.bookServ = bookServ; 
	 }
    
    //login reg
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User users = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", users.getId());
       
        return "redirect:/dashboard";
    }
    
    //login reg ends
    
    @RequestMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
    	if(session.getAttribute("user_id")!= null) {
    		
    		User user = userServ.findUser((Long) session.getAttribute("user_id"));
    		Long user_id = (Long) session.getAttribute("user_id");
    		
    		List<Book> allBooks = bookServ.allBooks();

    		model.addAttribute("book", allBooks);
    		model.addAttribute("user", userServ.findUser(user_id));
    		
    		return "/books/dashboard.jsp";
    	} else {
    		return "rediret:/";
    	}
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user_id");
        return "redirect:/";
    }
    

}