package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {
	
	private AuthService authService;
	
	@Autowired
	public AuthsController(AuthService authService) {
		this.authService= authService;
	}
	
	@PostMapping("/registerCandidate")
	public Result registerCandidate(@RequestBody CandidateForRegisterDto candidateDto) {
		return this.authService.registerCandidate(candidateDto);
	}
	
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody EmployerForRegisterDto employerDto) {
		return this.authService.registerEmployer(employerDto);
	}
	
	@PostMapping("/loginUser")
		Result login(@RequestParam String email,@RequestParam String password) {
			return this.authService.login(email, password);
		//?
	}
}
