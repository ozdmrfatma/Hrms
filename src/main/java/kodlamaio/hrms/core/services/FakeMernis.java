package kodlamaio.hrms.core.services;

import java.time.LocalDate;


public class FakeMernis {

	public boolean TCKimlikDogrula(long TCNo, String firstName, String lastName, LocalDate dateOfBirth) {
			if(Long.toString(TCNo)==null||dateOfBirth==null||Long.toString(TCNo).length()!=11) {
			return false;
		}
		return true;
	}


	
}
