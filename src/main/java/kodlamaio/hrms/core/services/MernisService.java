package kodlamaio.hrms.core.services;

import java.time.LocalDate;

public interface MernisService {
	boolean TCKimlikDogrula(long TCNo, String firstName,String lastName ,LocalDate dateOfBirth);
}	
