package com.projet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.projet.model.UserForm;
import com.projet.model.Utilisateur;
import com.projet.service.AccountService;

import Exception.ResourceNotFoundException;




@RestController
//@RequestMapping("/api/u1/")


public class UserController {
	@Autowired
	//private UserRepository UserRepository ;
	private AccountService accountService ;
	
/*	@GetMapping("/users")
	public List<User> getAllUsers(){
		return  (List<User>) UserRepository.findAll();
	}	
	@GetMapping("/users/{email}")
	public User getUserByEmail(@PathVariable ("email") String email) {
		return UserRepository.findByemailUser(email);
		}
		
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return UserRepository.save(user);
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
		User user = UserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
	
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
	
		User updatedUser = UserRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	
	
	

}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		User user = UserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		UserRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	} */
	@PostMapping("/register")
	public Utilisateur register(@RequestBody UserForm userForm) {
		return accountService.saveUser(userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword());
		
	}
	}
