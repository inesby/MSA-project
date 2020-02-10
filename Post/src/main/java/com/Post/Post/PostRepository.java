package com.Post.Post;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



import org.springframework.stereotype.Repository;




@Repository
public interface PostRepository extends JpaRepository<PostBean, Integer> {

	
    public List<PostBean>findAll();
    public Optional<PostBean> findById(int id);
    public PostBean findByIdUser(int id);
    public PostBean save(PostBean user);
    public List<PostBean> findByPosttLike(String recherche);

    public void deleteById(int id);
}
