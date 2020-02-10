package com.ForumUI.ForumUI;

import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.*;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.ForumUI.ForumUI.*;
import org.springframework.stereotype.*;

@Controller
public class FController {

	  @Autowired
	    private MicroserviceUserProxy UserProxy;

	  @Autowired
	    private MicroservicePostProxy PostProxy;
	  
	  @Autowired
	    private MicroserviceCommentProxy CommentProxy;
	  
	    @RequestMapping("/")
	    public String accueil(Model model){

	        List<UserBean> users =  UserProxy.listUsers();

	        model.addAttribute("Users", users);

	        
	        List<PostBean> posts =  PostProxy.listPosts();

	        model.addAttribute("Posts", posts);

	        
	        return "Accueil";
	    }
	    
	    
	    @RequestMapping("/details-post/{id}")
	    public String fichePost(@PathVariable int id,  Model model){

	     

	        List<CommentBean> comments = CommentProxy.listCommentsByPostId(id);

	        model.addAttribute("Comments", comments);
	        
	        Optional<PostBean> post =  PostProxy.listPostById(id);
            if( post.isPresent())
	        model.addAttribute("Posts", post.get());

	        return "DetailPost";
	    }
	    
	    

	
}
