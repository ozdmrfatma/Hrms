package kodlamaio.hrms.business.validationRules;

import java.time.LocalDate;

import kodlamaio.hrms.core.utilities.results.Result;

public interface UserCheckService {
	Result checkIfRealPerson(long identityNumber,String firstName,String lastName,LocalDate dateOfBirth);
	
}
