package kodlamaio.hrms.core.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements UserCheckService{

	@Override
	public boolean checkIfRealPerson(long identityNumber, String firstName, String lastName, LocalDate dateOfBirth) {
		
		FakeMernis client=new FakeMernis();
		boolean result=client.TCKimlikDogrula(identityNumber, firstName, lastName, dateOfBirth);
		return result;
	}

}
