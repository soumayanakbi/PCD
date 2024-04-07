package com.trainTruck.demo.Service;

import javax.management.relation.Role;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.trainTruck.demo.Config.JwtService;
import com.trainTruck.demo.Controller.auth.AuthenticationRequest;
import com.trainTruck.demo.Controller.auth.AuthenticationResponse;
import com.trainTruck.demo.Controller.auth.RegisterRequest;
import com.trainTruck.demo.Model.User;
import com.trainTruck.demo.Repository.UserRepository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository userRepo;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request)
	{
		User user= User.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.phoneNumber(request.getPhoneNumber())
				.password_user(passwordEncoder.encode(request.getPassword_user()))
				.role(com.trainTruck.demo.Model.Role.USER)
				.build();
		userRepo.save(user);
		var jwtToken=jwtService.generateToken(user);
	  return AuthenticationResponse.builder().token(jwtToken).build();	
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request)
	{
	  
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getPhoneNumber(), request.getPassword_user())
				);
		
		var user =userRepo.findByPhoneNumber(request.getPhoneNumber()).orElseThrow();
		var jwtToken=jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();		
	}
}
