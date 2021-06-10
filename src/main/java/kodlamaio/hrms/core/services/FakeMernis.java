package kodlamaio.hrms.core.services;

import java.time.LocalDate;


public class FakeMernis implements MernisService{

	@Override
	public boolean TCKimlikDogrula(long TCNo, String firstName, String lastName, LocalDate dateOfBirth) {
	//		if(identityNumber==null||dateOfBirth==null||identityNumber.length()!=11) {
	//		return false;
	//	}
		return true;
	}


	
}
