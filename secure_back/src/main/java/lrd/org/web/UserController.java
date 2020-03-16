package lrd.org.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lrd.org.entities.AppUser;
import lrd.org.services.AccountService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("users")
	public AppUser addUser(@RequestBody RegistationForm user) {
		
		if(!(user.getPassword()).equals(user.getRepassword())){
            throw new RuntimeException("You must confirm your password");
        }
        AppUser appUser = accountService.findUserByUsername(user.getUsername());

        if(appUser != null) throw new RuntimeException("This user already exists, Try an other username");
      
        AppUser u = new AppUser();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        accountService.addUser(u);
        accountService.addRoleToYUser(u.getUsername(), "USER");
        return u;
	}
}
