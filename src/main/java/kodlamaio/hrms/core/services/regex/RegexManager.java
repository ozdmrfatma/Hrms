package kodlamaio.hrms.core.services.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
@Service
public class RegexManager implements RegexService{

	@Autowired
	public RegexManager() {
		
	}
	
	@Override
	public Result checkEmailControl(String email) {
		String format = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

	    Pattern pattern = Pattern.compile(format);
	    Matcher matcher = pattern.matcher(email);
	    	
	    if(!(matcher.matches())) {
	    	return new ErrorResult("Email formata uygun değil !");
	    }
	    	return new SuccessResult();
			
	}

	@Override
	public Result checkWebAddressControl(String webAddress) {
		String format="(?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\\.)+[a-z0-9][a-z0-9-]{0,61}[a-z0-9]";
		
		Pattern pattern=Pattern.compile(format);
		Matcher matcher=pattern.matcher(webAddress);
		
		if(!(matcher.matches())) {
			return new ErrorResult("Web adress formata uygun değil!");
		}
		
		return new SuccessResult();
		
	}

	@Override
	public Result checkPhoneNumber(String phone) {
		String format="/^[+]*[0-9]*[ ]{0,1}[(]{0,1}[ ]{0,1}[0-9]{1,3}[ ]{0,1}[)]{0,1}[ ]{0,1}[0-9]{1,3}[ ]{0,1}[0-9]{2}[ ]{0,1}[0-9]{2}[ ]{0,1}[-\\.\\/]{0,1}[ ]{0,1}[0-9]{1,5}$/g";
				
		Pattern pattern =Pattern.compile(format);
		Matcher matcher=pattern.matcher(phone);
		
		if(!(matcher.matches())) {
			return new ErrorResult("Telefon numarası formatına uygun değil!");
		}
		return new SuccessResult();
	}

}
