package com.Post.Post;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.Post.Post.UserBean;
import java.util.List;
import java.util.Optional;
import java.util.* ;
@FeignClient(name = "User", url = "localhost:9091")
public interface MicroserviceUserProxy {
	

@GetMapping(value = "/Users")
List<UserBean> listUsers();

@GetMapping( value = "/Users/{id}")
Optional<UserBean> listUserById (@PathVariable("id") int id);


}
