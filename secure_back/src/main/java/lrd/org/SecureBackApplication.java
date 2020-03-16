package lrd.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lrd.org.entities.AppRole;
import lrd.org.entities.AppUser;
import lrd.org.services.AccountService;

@SpringBootApplication
public class SecureBackApplication implements CommandLineRunner{

	@Autowired 
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(SecureBackApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBcryp() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
//		AppUser admin = accountService.addUser(new AppUser("admin", "1234") );
//		AppUser user = accountService.addUser(new AppUser("user", "1234") );
//		
//		AppRole adminRole = accountService.addRole(new AppRole("ADMIN"));
//		AppRole userRole = accountService.addRole(new AppRole("USER"));
//		
//		accountService.addRoleToYUser(admin.getUsername(), adminRole.getRoleName());
//		accountService.addRoleToYUser(admin.getUsername(), userRole.getRoleName());
//		accountService.addRoleToYUser(user.getUsername(), userRole.getRoleName());
		
	}
	
	

}
