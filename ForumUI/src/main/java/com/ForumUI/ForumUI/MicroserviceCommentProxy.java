package com.ForumUI.ForumUI;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ForumUI.ForumUI.UserBean;


import java.util.List;
import java.util.Optional;
import java.util.* ;
@FeignClient(name = "Comment", url = "localhost:9093")
public interface MicroserviceCommentProxy {
	

@GetMapping(value = "/Users")
List<UserBean> listUsers();

@GetMapping( value = "/Comments/posts/{id}")
List<CommentBean> listCommentsByPostId (@PathVariable("id") int id);




}
