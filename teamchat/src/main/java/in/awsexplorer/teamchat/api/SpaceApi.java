package in.awsexplorer.teamchat.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.awsexplorer.teamchat.model.Space;
import in.awsexplorer.teamchat.repo.SpaceRepository;

@RestController
@RequestMapping("/api/space")
public class SpaceApi {
	
	@Autowired
	private SpaceRepository spaceRepository;
	
	@GetMapping("/all")
	public List<Space> findAll() {
		List<Space> spaces = spaceRepository.findAll();
		return spaces;
	}
	
	@PostMapping("/add")
	public String addSpace(@RequestBody Space space) {
		System.out.println("space:"+space.toString());
		Timestamp tnow=new Timestamp(new Date().getTime());
		space.setCreateTime(tnow);
		spaceRepository.save(space);
		return "SUCCESS";
	}


}
