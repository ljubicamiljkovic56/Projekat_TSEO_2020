package projekatTSEO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.User;
import projekatTSEO.app.repository.UserRepository;

@Service
public class UserService {
	
//	@Autowired
//	public UserRepository userRepository;
//	
//	 public String checkUserRole(String username, String password) {
//	    	User user = userRepository.findByUsername(username);
//	    	if(user == null) {
//	    		System.out.println("Wrong username or password.");
//	    	}else if (user.getPassword().equals(password)){
//	    		if(user.getRole().getName().equals("admin")) {
//	    			System.out.println("Logged in as admin");
//	    		}else if(user.getRole().getName().equals("student")){
//	    			System.out.println("Logged in as student");
//	    		}else if(user.getRole().getName().equals("teacher")){
//	    			System.out.println("Logged in as teacher");
//	    		}
//	    	}else {
//	    		System.out.println("Error");
//	    		
//	    	}
//	    	return user.getRole().toString();
//	    }

}
