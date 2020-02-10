package com.ForumUI.ForumUI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import java.util.List;
import java.util.Optional;
import java.util.* ;

@FeignClient(name = "Post", url = "localhost:9092")
public interface MicroservicePostProxy {

	@GetMapping( value = "/Posts/{id}")
	Optional<PostBean> listPostById (@PathVariable("id") int id);
	
	@GetMapping( value = "/Posts")
	List<PostBean> listPosts();


	
}
