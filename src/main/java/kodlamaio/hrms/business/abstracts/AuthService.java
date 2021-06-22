package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

public interface AuthService {
	Result registerCandidate(CandidateForRegisterDto candidateDto);
	Result registerEmployer(EmployerForRegisterDto employerDto);
	Result login(String email,String password);
	
}
