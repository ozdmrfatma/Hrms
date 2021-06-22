package kodlamaio.hrms.core.services.regex;

import kodlamaio.hrms.core.utilities.results.Result;

public interface RegexService {
	Result checkEmailControl(String email);
	Result checkWebAddressControl(String webAddress);
	Result checkPhoneNumber(String phone);
}

