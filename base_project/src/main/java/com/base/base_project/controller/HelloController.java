package com.base.base_project.controller;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.base.base_project.model.RoleType;
import com.base.base_project.model.User;
import com.base.base_project.repositroy.UserRepositroy;

@RestController
public class HelloController {

    @Autowired
    private UserRepositroy userRepositroy;
    
    @GetMapping("dummy/user/{id}")
    public User getUser(@PathVariable int id) {
        User user = userRepositroy.findById(id)
            .orElseThrow(new Supplier<IllegalArgumentException>() {
                @Override
                public IllegalArgumentException get() {
                    return new IllegalArgumentException("해당 유저는 존재하지 않습니다. id : " + id);
                }
            });
        
        return user;
    }

    @GetMapping("/dummy/user")
	public List<User> list() {
		return userRepositroy.findAll();
	}

    @GetMapping("/dummy/user/page")
	public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		List<User> users = userRepositroy.findAll(pageable).getContent();
		return users;
	}

    @PostMapping("/dummy/join")
	public String join(User user) {
		
		System.out.println("id : " + user.getId());
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("createdate : " + user.getCreatedDate());
		
		user.setRole(RoleType.USER);
		userRepositroy.save(user);
		
		return "회원가입이 완료되었습니다.";	
	}

    @Transactional // 함수 종료 시에 자동 commit 진행
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id : " + id);
		System.out.println("password : " + requestUser.getPassword());
		System.out.println("email : " + requestUser.getEmail());
        User user = userRepositroy.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());

		userRepositroy.save(user);
		
		return user;
	}

    @DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		
		try {
			userRepositroy.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다. 해당 id는 DB에 존재하지 않습니다.";
		}	
		
		return "삭제되었습니다. id : " + id;
	}
}
