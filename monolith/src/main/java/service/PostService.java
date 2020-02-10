package service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import exceptions.PostNotFoundException;
import model.PostBean;
import repository.PostRepository;
import repository.UserRepository;


@Service
public class PostService {

	
    
    @Autowired
    private PostRepository post;
	
	

    public List<PostBean> listPosts() {
		return post.findAll();
    }
	
	
	
	
	  public Optional<PostBean> listPostById(int id) {
		 
		  Optional<PostBean> p = post.findById(id);

	        if (!p.isPresent()) {throw new PostNotFoundException("Post not found");}

	        return p;

		  
		  
	  }
	
	  
	
	
	    public List<PostBean> testeDeRequetes( String recherche) {
	        return post.findByPosttLike("%"+recherche+"%");
	    }
  

	    public PostBean AddUser( PostBean postt) {
	
	        
	        PostBean postAdded =  post.save(postt);

	 
	        return postAdded ;
	    }

	
	  

	   public void supprimerProduit( int id) {
		  Optional<PostBean> p = post.findById(id);

	        if (!p.isPresent()) {throw new PostNotFoundException("Post not found");}
	        post.deleteById(id);
	   }
	  

	
	    public PostBean AddUserpos( PostBean postt) {
		   PostBean postAdded =  post.save(postt);

			 
	        return postAdded ;
	    }
    
    
}
