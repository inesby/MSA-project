package repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



import org.springframework.stereotype.Repository;

import model.CommentBean;




@Repository
public interface CommentRepository extends JpaRepository<CommentBean, Integer> {

	
    public List<CommentBean>findAll();
    public Optional<CommentBean> findById(int id);
    public List<CommentBean> findByIdpost(int id);
    public CommentBean save(CommentBean comment);
    public List<CommentBean> findByCommentLike(String recherche);

    public void deleteById(int id);
}
