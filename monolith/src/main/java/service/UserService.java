package service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import exceptions.UserNotFoundException;
import model.UserBean;
import repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userDao;
	
	
    public List<UserBean> listUsers() {
		return userDao.findAll();
    }
	
	
	
	

	  public Optional<UserBean> listUserById( int id) {
		  
		  Optional<UserBean> p = userDao.findById(id);

	        return p;

		
	  }
	
	  
	  public List<UserBean> testeDePrix(int ageLimit) {
	      return userDao.findByAgeGreaterThan(ageLimit);
	  }
	  

	    public List<UserBean> testeDeRequetes( String recherche) {
	        return userDao.findByNameLike("%"+recherche+"%");
	    }
  
	
	    public ResponseEntity<Void> AddUser( UserBean user) {

		  UserBean userAdded =  userDao.save(user);

	        if (userAdded == null)
	            return ResponseEntity.noContent().build();

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(userAdded.getId())
	                .toUri();

	        return ResponseEntity.created(location).build();
	    }

	
	  
	 
	   public void supprimerProduit( int id) {
		  Optional<UserBean> p = userDao.findById(id);

	        if (!p.isPresent()) {throw new UserNotFoundException("User not found");}
	       userDao.deleteById(id);
	   }
	  

	
	  public ResponseEntity<Void> AddUserpos(UserBean user) {

		  UserBean userAdded =  userDao.save(user);

	        if (userAdded == null)
	            return ResponseEntity.noContent().build();

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(userAdded.getId())
	                .toUri();

	        return ResponseEntity.created(location).build();
	    }

}
