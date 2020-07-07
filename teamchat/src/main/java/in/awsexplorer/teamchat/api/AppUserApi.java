package in.awsexplorer.teamchat.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.awsexplorer.teamchat.model.AppUser;
import in.awsexplorer.teamchat.repo.AppUserRepository;


@RestController
@RequestMapping("/api/appuser")
public class AppUserApi {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@GetMapping("/all")
	public List<AppUser> findAll() {
		List<AppUser> allAppUsers = appUserRepository.findAll();
		return allAppUsers;
	}
	
	@GetMapping("/{id}")
	public AppUser findAppUser(@PathVariable(value="id") int id) {
		Optional<AppUser> appUser = appUserRepository.findById(id);
		if ( appUser.isPresent() ) {
			return appUser.get();
		}
		return null ;
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody AppUser appUser) {
		System.out.println("appUser:"+appUser.toString());
		Timestamp tnow=new Timestamp(new Date().getTime());
		appUser.setUpdateTime(tnow);
		
		appUserRepository.save(appUser);
		return "SUCCESS";
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody AppUser appUser) throws Exception {
		System.out.println("appUser:"+appUser.toString());
		if ( appUser.getAppUserId() == 0 ) {
			throw new Exception("Missing App id.");
		}
		Timestamp tnow=new Timestamp(new Date().getTime());
		appUser.setUpdateTime(tnow);
		
		appUserRepository.save(appUser);
		return "SUCCESS";
	}

}
