package projekatTSEO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projekatTSEO.service.UserService;


@RestController
public class LoginController {

	@Autowired
	public UserService userService;	
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
		System.out.println(username);
		System.out.println(password);
		
		String userAuth = userService.checkUserRole(username, password);
		
		
		
		return new ResponseEntity<String>(userAuth, HttpStatus.CREATED);
      
	}

}
