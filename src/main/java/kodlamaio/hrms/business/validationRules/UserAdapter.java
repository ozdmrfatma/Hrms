package kodlamaio.hrms.business.validationRules;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.services.FakeMernis;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class UserAdapter implements UserCheckService{
	
	@Override
	public Result checkIfRealPerson(long identityNumber, String firstName, String lastName, LocalDate dateOfBirth) {
		
		FakeMernis client=new FakeMernis();
		boolean result=client.TCKimlikDogrula(identityNumber, firstName, lastName, dateOfBirth);
		
		if(!result) {
			return new ErrorResult("Kullanıcı doğrulanamadı!");
		}
		
		return new SuccessResult();
	}

	

}
