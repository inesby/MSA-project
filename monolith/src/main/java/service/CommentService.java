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

import exceptions.CommentNotFoundException;
import model.CommentBean;
import repository.CommentRepository;
@Service
public class CommentService {

	

	
    @Autowired
    private CommentRepository comment;
	
	

    public List<CommentBean> listComments() {
		return comment.findAll();
    }
	
	
	  public List<CommentBean> listCommentsByPostId( int id) {
			return comment.findByIdpost(id);
	    }
	
	

	  public Optional<CommentBean> listPostById( int id) {
		 
		  Optional<CommentBean> p = comment.findById(id);

	        if (!p.isPresent()) {throw new CommentNotFoundException(id);}

	        return p;

		  
		  
	  }
	
	  
	
	  

	    public List<CommentBean> testeDeRequetes(String recherche) {
	        return comment.findByCommentLike("%"+recherche+"%");
	    }
  
	    
	    
	//ajouter un commentaire

	    public CommentBean AddComment(CommentBean c) {
  
	        CommentBean commentAdded =  comment.save(c);
	        	return commentAdded ;
	    }

	
	  

	   public void supprimerCommentaire(int id) {
		  Optional<CommentBean> p = comment.findById(id);

	        if (!p.isPresent()) {throw new CommentNotFoundException(id);}
	        comment.deleteById(id);
	   }
	  


    
    
    
}
