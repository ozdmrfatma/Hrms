package kodlamaio.hrms.business.validationRules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class CandidateValidationManager implements CandidateValidationService{

	private CandidateService candidateService;
	private UserService userService;
	
	@Autowired
	public CandidateValidationManager(CandidateService candidateService,UserService userService){
		this.candidateService=candidateService;
		this.userService =userService;
	}

	@Override
	public Result isIdentityExist(String identityNumber) {
		
		if((this.candidateService.getByIdentity(identityNumber)).getData()!=null) {					
			return new ErrorResult("TCno (identity number) zaten kayıtlı!");
		}
		else {

			return new SuccessResult();
		}
		
		
	}

	@Override
	public Result isEmailExist(String email) {
		if((this.userService.getByEmail(email)).getData()==null) {
		
			return new SuccessResult();		
		}
		else{
			return new ErrorResult("Email zaten kayıtlı.");		///	
			
		}
	}

	@Override
	public Result isPasswordEqual(String password, String passwordAgain) {			
		if(!(password.equals(passwordAgain))) {
			return new ErrorResult("Şifre tekrarı ile uyuşmuyor");
		}
		else {
			return new SuccessResult();
		}
	}
	
	

	

}
