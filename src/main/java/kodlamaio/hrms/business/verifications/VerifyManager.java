package kodlamaio.hrms.business.verifications;

import java.util.UUID;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class VerifyManager implements VerifyService{
	
	@Override
	public Result sendVerifyCode(String email) {
			
		 UUID link=UUID.randomUUID();
		 String verifyLink="https://hrms/verificationmail/"+link.toString();
		 return new SuccessResult(email+" adresine doğrulama kodu gönderildi\"");
	}

	@Override
	public String codeGenerate() {
		
		UUID code=UUID.randomUUID();
		String verifyCode=code.toString().toUpperCase();
		
		return verifyCode;
	}

	
}
