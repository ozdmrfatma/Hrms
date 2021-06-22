package kodlamaio.hrms.business.verifications;

import kodlamaio.hrms.core.utilities.results.Result;

public interface VerifyService {
	Result sendVerifyCode(String email);
	String codeGenerate();
}
