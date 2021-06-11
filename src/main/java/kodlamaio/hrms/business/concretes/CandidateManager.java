package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.services.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserCheckService checkService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,UserCheckService checkService) {
		this.candidateDao=candidateDao;
		this.checkService=checkService;
	}
	
	
	@Override
	public Result add(Candidate candidate) {
		
		
		if(!(candidate.getFirstName().isEmpty()&&candidate.getLastName()==null&&candidate.getDateOfBirth()==null&&candidate.getIdentityNumber()==null&&candidate.getEmail()==null&&candidate.getPassword()==null)){
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		}
		
		
		if(!(checkIfRealPerson(candidate))){
			return new ErrorResult("Candidate doğrulama başarısız");
		}
		
		if(candidateDao.getByEmail(candidate.getEmail())!=null) {
			return new ErrorResult("email zaten kayıtlı!");
		}
		
		if(candidateDao.getByIdentityNumber(candidate.getIdentityNumber())!=null) {
			return new ErrorResult("TCno (identity number) zaten kayıtlı!");
		}
			
		candidateDao.save(candidate);
		return new SuccessResult(candidate.getFirstName() +" eklendi" );
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"İş arayanlar Listelendi");

	}
	public boolean checkIfRealPerson(Candidate candidate) {
		if(!(checkService.checkIfRealPerson(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName(), candidate.getLastName(), candidate.getDateOfBirth()))) {
			return false;
		}
			return true;
		
	
}
	
}
