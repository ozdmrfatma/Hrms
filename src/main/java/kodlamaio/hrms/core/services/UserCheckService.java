package kodlamaio.hrms.core.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;


//@Service
public interface UserCheckService {
	public boolean checkIfRealPerson(long identityNumber,String firstName,String lastName,LocalDate dateOfBirth);
}
