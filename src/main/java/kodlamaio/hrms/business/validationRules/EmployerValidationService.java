package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmployerValidationService{
	Result domainControl(String webAddress ,String email);		
	Result isEmailExist(String email);
	Result isPasswordEqual(String password,String passwordAgain);

}
