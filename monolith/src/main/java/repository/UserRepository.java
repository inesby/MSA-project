package repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;




import model.UserBean;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer>{

	    public List<UserBean>findAll();
	    public Optional<UserBean> findById(int id);
	    public UserBean save(UserBean user);
	    public List<UserBean> findByAgeGreaterThan(int age);
	    public List<UserBean> findByNameLike(String recherche);

	    public void deleteById(int id);
	
}
