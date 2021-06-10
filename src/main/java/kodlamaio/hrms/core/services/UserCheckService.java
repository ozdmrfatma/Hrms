package kodlamaio.hrms.core.services;

import java.time.LocalDate;


public interface UserCheckService {
	public boolean checkIfRealPerson(long identityNumber,String firstName,String lastName,LocalDate dateOfBirth);
}
