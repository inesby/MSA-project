package controller;
  

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import exceptions.PostNotFoundException;
import exceptions.UserNotFoundException;
import model.CommentBean;
import model.PostBean;
import model.UserBean;
import repository.PostRepository;
import repository.UserRepository;
import service.CommentService;

import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.*;

@RestController
public class CommentController {

	
    @Autowired
    private CommentService comment;
	
    @Autowired 
    UserRepository user ;
    
    @Autowired 
    PostRepository  post ;
	
	@RequestMapping(value="/Comments", method=RequestMethod.GET)
    public List<CommentBean> listComments() {
		return comment.listComments();
    }
	
	
	@RequestMapping(value="/Comments/posts/{id}", method=RequestMethod.GET)
	  public List<CommentBean> listCommentsByPostId(@PathVariable int id) {
			return comment.listCommentsByPostId(id);
	    }
	
	
	  @GetMapping(value ="/Comments/{id}")
	  public Optional<CommentBean> listPostById(@PathVariable int id) {
		 
		  
	        return comment.listPostById(id);

		  
		  
	  }
	
	  
	
	  
	  @GetMapping(value = "/Comments/keywords/{recherche}")
	    public List<CommentBean> testeDeRequetes(@PathVariable String recherche) {
	        return comment.testeDeRequetes("%"+recherche+"%");
	    }
  

	  @PutMapping (value = "/Comments")
	    public ResponseEntity<Void> AddComment(@RequestBody CommentBean c) {
	/*	  Optional<UserBean> p = UserProxy.listUserById(c.getIduser());

	        if (!p.isPresent()) {throw new UserNotFoundException("User not found");}
	        
	       Optional<PostBean> a = PostProxy.listPostById(c.getIdpost());

	        if (!a.isPresent()) {throw new PostNotFoundException("Post not found");}
	  */      
	        
	        CommentBean commentAdded =  comment.AddComment(c);

	        if (commentAdded == null)
	            return ResponseEntity.noContent().build();

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(commentAdded.getId())
	                .toUri();

	        return ResponseEntity.created(location).build();
	    }

	
	  
	  @DeleteMapping (value = "/Comments/{id}")
	   public void supprimerCommentaire(@PathVariable int id) {
		 comment.supprimerCommentaire(id);
	   }
	  

	  @PostMapping(value = "/Posts")
	    public ResponseEntity<Void> AddCommentpost(@RequestBody CommentBean c) {
			 Optional<UserBean> p = user.findById(c.getIduser());

		        if (!p.isPresent()) {throw new UserNotFoundException("User not found");}
		        
		       Optional<PostBean> a = post.findById(c.getIdpost());

		        if (!a.isPresent()) {throw new PostNotFoundException("Post not found");}
		       
		        
		        CommentBean commentAdded =  comment.AddComment(c);

		        if (commentAdded == null)
		            return ResponseEntity.noContent().build();

		        URI location = ServletUriComponentsBuilder
		                .fromCurrentRequest()
		                .path("/{id}")
		                .buildAndExpand(commentAdded.getId())
		                .toUri();

		        return ResponseEntity.created(location).build();
		    }
    
    
    
	
}
