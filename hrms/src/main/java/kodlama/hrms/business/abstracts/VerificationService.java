package kodlama.hrms.business.abstracts;

public interface VerificationService {
	boolean sendVerificationCode(String emailAddress);
	
}
