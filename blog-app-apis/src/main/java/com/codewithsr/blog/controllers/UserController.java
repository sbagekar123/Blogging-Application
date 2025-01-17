package com.codewithsr.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codewithsr.blog.payloads.ApiResponse;
import com.codewithsr.blog.payloads.UserDto;
import com.codewithsr.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//POST-create user
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createUser= this.userService.createUser(userDto);
	
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}
	
	//PUT - update user
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid)
	{
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);	
	}
	
	
	//DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid)
	{
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
	}
	
	//GET - user get
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
	
	//GET - user get - single user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
		
	}
	
//	// Get - Already deleted User - Getting Exception- ResourceNotFoundException: User not found with id 
//	@GetMapping("/delete/{userId}")
//	public ResponseEntity<ApiResponse> getSingleUserwithException(@PathVariable Integer userId) {
//		this.userService.getUserById(userId);
//		return new ResponseEntity<ApiResponse>(new ApiResponse("User is Deleted already with this Id", false), HttpStatus.NOT_FOUND);
//	}
//	
	
}
