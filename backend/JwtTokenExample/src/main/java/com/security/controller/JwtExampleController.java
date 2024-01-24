package com.security.controller;

import java.util.Optional;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.configs.dto.AuthRequest;
import com.security.configs.entity.Bank;
import com.security.configs.entity.Credit;
import com.security.configs.entity.UserInfo;
import com.security.configs.service.JwtService;
import com.security.repository.JwtExampleRepository;
import com.security.repository.bankRepository;
import com.security.repository.creditRepository;

@RestController
@RequestMapping(value="/jwt")
@CrossOrigin(origins = "*")
public class JwtExampleController {
	

	@Autowired
	JwtExampleRepository jwtRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	bankRepository bankres;
	
	@Autowired
	JwtExampleRepository jwtres;
	
	@Autowired
   creditRepository creditres;	
	
	@GetMapping(value="/get")
	public String getMessage() {
		return "hello everyone";
	}
	
	@GetMapping(value="/getAdmin")
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getAdmin() {
		return "hello admin";
	}
	@PostMapping(value="/newaccount")
    public Bank inset(@RequestBody Bank a) {
		return bankres.save(a);
		 
		
	}
	@GetMapping(value="/getUser/{name}")
	
	public Optional<UserInfo> getUser(@PathVariable String name) {
		return jwtres.findByName(name);
	}
	@PostMapping(value="/credit")
	public Credit addcredit(@RequestBody Credit u) {
		return creditres.save(u);
	}
//@GetMapping(value="/getUser/{mobile}")
//	
//	public Optional<UserInfo> getmobile(@PathVariable long mobile) {
//		return jwtres.findByMobile(mobile);
//	}
	
	 	
	@PostMapping(value="/addUser")
	public UserInfo addUser(@RequestBody UserInfo user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		 return jwtRepo.save(user);
	}
	
	
	@PostMapping(value="/authenticate")
	public String createToken(@RequestBody AuthRequest authRequest)  {
		try {
		Authentication authentication= authManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest
						.getUsername(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
		
//		return jwtService.generatedToken(authRequest.getUsername());
			return "login ok";
		}
		else {
//			throw new UsernameNotFoundException("invalid user!");
			return "invalid user";
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			return "Invalid Userxk";
		}
		
	}
	
	
	
//	@PostMapping(value="/authenticate")
//	public String autheniticateAndGetToken(@RequestBody AuthRequest authRequest) {
//		Authentication authenticator= authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//		if(authenticator.isAuthenticated()) {
//			return jwtService.generateToken(authRequest.getUsername());
//		}
//		else {
//			throw new UsernameNotFoundException("invalid user request!");
//		}
//
//	
//	}



}
