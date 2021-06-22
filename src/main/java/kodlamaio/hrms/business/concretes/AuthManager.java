package kodlamaio.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.validationRules.CandidateValidationService;
import kodlamaio.hrms.business.validationRules.EmployerValidationService;
import kodlamaio.hrms.business.validationRules.UserCheckService;
import kodlamaio.hrms.business.verifications.VerifyService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.dtos.CandidateForRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerForRegisterDto;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;


@Service
public class AuthManager implements AuthService{

	private CandidateService candidateService;
	private EmployerService employerService;
	private EmployerValidationService eService;
	private CandidateValidationService cService;
	private VerifyService verifyService;
	private UserCheckService checkService;
	private VerificationCodeService codeService;
	
	private ModelMapper modelMapper;
	
	@Autowired
	public AuthManager(ModelMapper modelMapper,CandidateService candidateService,EmployerService employerService,EmployerValidationService eService,CandidateValidationService cService,VerifyService verifyService,UserCheckService checkService) {
		this.candidateService=candidateService;
		this.employerService=employerService;
		this.eService=eService;
		this.cService=cService;
		this.verifyService=verifyService;
		this.checkService=checkService;
		this.modelMapper=modelMapper;
	}
	
	@Override
	public Result registerCandidate(CandidateForRegisterDto candidateDto) {
		
		Candidate candidate=modelMapper.map(candidateDto, Candidate.class);
		
		
		Result businessRules1=BusinessRules.Run(this.checkService.checkIfRealPerson(Long.valueOf(candidateDto.getIdentityNumber()), candidateDto.getFirstName(), candidateDto.getLastName(), candidateDto.getDateOfBirth()),
												this.cService.isPasswordEqual(candidateDto.getPassword(), candidateDto.getPasswordAgain()),
												this.cService.isIdentityExist(candidateDto.getIdentityNumber()),
												this.cService.isEmailExist(candidateDto.getEmail()));
												
		
		//this.generateVerificationCode(candidateDto.getId(),candidate.getEmail());
		
		if(businessRules1.isSuccess()) {
			
			this.candidateService.add(candidate);
			return new SuccessResult(candidate.getFirstName()+"candidate için register işlemi başarılı.");
		}
		else {

			return new ErrorResult(businessRules1.getMessage());
		}

	}

	@Override
	public Result registerEmployer(EmployerForRegisterDto employerDto) {
	
		Employer employer=modelMapper.map(employerDto, Employer.class);
		
		Result businessRule1=BusinessRules.Run(this.eService.isPasswordEqual(employerDto.getPassword(), employerDto.getPasswordAgain()),
											  this.eService.domainControl(employerDto.getWebAddress(),employerDto.getEmail()),
											  this.eService.isEmailExist(employerDto.getEmail()));
		
//		if((businessRule1.isSuccess())) {
//			this.employerService.add(employer);		
//			return new SuccessResult(employerDto.getCompanyName()+" Employer için register işlemi başarılı.");
//		}
//		else{
//			return new ErrorResult(businessRule1.getMessage());
//		}
		if(!(businessRule1.isSuccess())) {
			return new ErrorResult(businessRule1.getMessage());
		}
		this.employerService.add(employer);
		return new SuccessResult(employerDto.getCompanyName()+" Employer için register işlemi başarılı.");
		
		
	}

	@Override
	public Result login(String email, String password) {
		
		return new SuccessResult("Login işlemi başarılı");
		
	}
	
	private Result generateVerificationCode(int userId,String email)
	{
		String code = this.verifyService.codeGenerate();
		this.verifyService.sendVerifyCode(code);		
		VerificationCode verificationCode = new VerificationCode(userId, code, false, LocalDate.now());
		
		this.codeService.add(verificationCode);
		
		return new SuccessResult();
	}

	
	
	
	

}






