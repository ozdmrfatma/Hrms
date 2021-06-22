package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.Result;

public interface CandidateValidationService{
		Result isIdentityExist(String identityNumber);
		Result isEmailExist(String email);
		Result isPasswordEqual(String password,String passwordAgain);
}
