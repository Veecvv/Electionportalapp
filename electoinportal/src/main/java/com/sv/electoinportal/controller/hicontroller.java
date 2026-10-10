package com.sv.electoinportal.controller;
import java.util.List;
import com.sv.electoinportal.model.Voters;
import com.sv.electoinportal.repo.VotersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class hicontroller {
	@Autowired
	VotersRepo votersRepos;
	//http://localhost:2005/voterslist ->list out all voters
	@GetMapping("/voterslist")
	List<Voters>getAllVotersList(){
		
         return votersRepos.findAll();
	}
	//http://localhost:2005/getvoter/2 ->get specific voter
	@GetMapping("/getvoter/{vid}")
	Voters getVoter(@PathVariable Integer vid)
	{
		return votersRepos.findById(vid).orElseThrow();
	}
	//http://localhost:2005/createvoterlist ->new voter
	@PostMapping("/createvoterlist")
	 Voters votecreatevoter(@RequestBody Voters voter)
	{
		return votersRepos.save(voter);
	}
	//http://localhost:2005/updatevoter/2->update voter
	@PutMapping("updatevoter/{vid}")
	 Voters updatevoter(@RequestBody Voters voter,@PathVariable Integer vid)
	{
		Voters voterfromdb=getVoter(vid);
		voterfromdb.setVname(voter.getVname());
		voterfromdb.setAge(voter.getAge());
		voterfromdb.setVc(voter.getVc());
		voterfromdb.setState(voter.getState());
		return votersRepos.save(voterfromdb);
	}
	//http://localhost:2005/deletevoter/4 ->delete voter
	@DeleteMapping("deletevoter/{vid}")
	String deletevoter(@PathVariable Integer vid)
	{
		votersRepos.deleteById(vid);
		return "voter deleted succesfully for id :"+vid;
	}
	
	
	

}
