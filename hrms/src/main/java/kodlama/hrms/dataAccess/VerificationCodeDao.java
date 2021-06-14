package kodlama.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {

	VerificationCode findByUserIdAndCode(int email,String code);
	
	VerificationCode findByCode(String code);
	VerificationCode findByUserId(int id);
}
