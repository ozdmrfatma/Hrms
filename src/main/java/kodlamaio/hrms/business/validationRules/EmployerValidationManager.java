package kodlamaio.hrms.business.validationRules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmployerValidationManager implements EmployerValidationService{

	
	private UserService userService;
	
	@Autowired
	public EmployerValidationManager(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public Result domainControl(String WebAddress ,String Email) {		
	   
		int index=Email.indexOf("@");
		String domain=Email.substring(index+1);
		
		if(!(WebAddress.contains(domain))) {
			return new ErrorResult("Web adresiniz ile aynı domaine sahip email adresiniz olmalıdır");
		}
		else {
			return new SuccessResult();
		}
		
	}

	@Override
	public Result isEmailExist(String email) {		
		if((this.userService.getByEmail(email)).getData()==null) {
			return new SuccessResult("Email Geçti");
		}
		else{
			return new ErrorResult("Email zaten kayıtlı");
		}
		
	}

	@Override
	public Result isPasswordEqual(String password, String passwordAgain) {		
		if(!(password.equals(passwordAgain))) {
			return new ErrorResult("Şifre uyuşmuyor");
		}
		else {
			return new SuccessResult();
		}
		
	}

	

}
