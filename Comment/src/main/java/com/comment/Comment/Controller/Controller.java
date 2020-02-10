package com.comment.Comment.Controller;
  

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.comment.Comment.Proxies.MicroserviceUserProxy;
import com.comment.Comment.Repository.CommentRepository;

import java.net.URI;
import java.util.*;
import com.comment.Comment.Exceptions.*;
import org.springframework.beans.factory.annotation.*;
import com.comment.Comment.Beans.*;
import com.comment.Comment.Proxies.MicroservicePostProxy;
@RestController
public class Controller {

 /*   @Autowired
    private MicroserviceUserProxy UserProxy;
    
	@Autowired
	@Qualifier("PostProxy")
    private MicroservicePostProxy PostProxy;

  */

	
	
	
    @Autowired
    private CommentRepository comment;
	
	
	@RequestMapping(value="/Comments", method=RequestMethod.GET)
    public List<CommentBean> listComments() {
		return comment.findAll();
    }
	
	
	@RequestMapping(value="/Comments/posts/{id}", method=RequestMethod.GET)
	  public List<CommentBean> listCommentsByPostId(@PathVariable int id) {
			return comment.findByIdpost(id);
	    }
	
	
	  @GetMapping(value ="/Comments/{id}")
	  public Optional<CommentBean> listPostById(@PathVariable int id) {
		 
		  Optional<CommentBean> p = comment.findById(id);

	        if (!p.isPresent()) {throw new CommentNotFoundException(id);}

	        return p;

		  
		  
	  }
	
	  
	
	  
	  @GetMapping(value = "/Comments/keywords/{recherche}")
	    public List<CommentBean> testeDeRequetes(@PathVariable String recherche) {
	        return comment.findByCommentLike("%"+recherche+"%");
	    }
  
	//ajouter un commentaire
	  @PutMapping (value = "/Comments")
	    public ResponseEntity<Void> AddComment(@RequestBody CommentBean c) {
	/*	  Optional<UserBean> p = UserProxy.listUserById(c.getIduser());

	        if (!p.isPresent()) {throw new UserNotFoundException("User not found");}
	        
	       Optional<PostBean> a = PostProxy.listPostById(c.getIdpost());

	        if (!a.isPresent()) {throw new PostNotFoundException("Post not found");}
	  */      
	        
	        CommentBean commentAdded =  comment.save(c);

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
		  Optional<CommentBean> p = comment.findById(id);

	        if (!p.isPresent()) {throw new CommentNotFoundException(id);}
	        comment.deleteById(id);
	   }
	  

	  @PostMapping(value = "/Posts")
	    public ResponseEntity<Void> AddCommentpost(@RequestBody CommentBean c) {
			/*  Optional<UserBean> p = UserProxy.listUserById(c.getIduser());

		        if (!p.isPresent()) {throw new UserNotFoundException("User not found");}
		        
		       Optional<PostBean> a = PostProxy.listPostById(c.getIdpost());

		        if (!a.isPresent()) {throw new PostNotFoundException("Post not found");}
		      */  
		        
		        CommentBean commentAdded =  comment.save(c);

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
