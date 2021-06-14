package kodlama.hrms.business.abstracts;

import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
		Result add(VerificationCode code);
		
		Result  codeAddUser(int userId);
	

		Result activateUser(String code);
}
