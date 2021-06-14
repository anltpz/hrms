package kodlama.hrms.business.concretes;

import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.VerificationCodeService;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.UserDao;
import kodlama.hrms.dataAccess.VerificationCodeDao;
import kodlama.hrms.entities.concretes.User;
import kodlama.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager  implements VerificationCodeService{

	private VerificationCodeDao verificationCodeDao;
	private UserDao userDao;
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao,UserDao userDao) {
		super();
		this.userDao=userDao;
		this.verificationCodeDao = verificationCodeDao;
	}
	@Override
	public Result add(VerificationCode code) {
		
		this.verificationCodeDao.save(code);
		return new SuccessResult("Code eklendi");
	}
	
	public String codeOlustur() {
		
		UUID uuid = UUID.randomUUID();
	    String code= uuid.toString();
		return code;
	}
	@Override
	public Result codeAddUser(int userId) {
		VerificationCode code = new VerificationCode();
		code.setConfirmed(false);
		code.setUserId(userId);
		code.setCode(codeOlustur());
		add(code);
		return new SuccessResult("Code eklendi");
	}
	

	
	@Override
    public Result activateUser(String code) {

        if(verificationCodeDao.findByCode(code) == null){
            return new ErrorResult("Kod hatalı");
        }

        User user = userDao.getById(verificationCodeDao.findByCode(code).getUserId());
        user.setEmailVerif(true);
        userDao.save(user);

        VerificationCode activationCode=verificationCodeDao.findByCode(code);
        activationCode.setConfirmed(true);
        verificationCodeDao.save(activationCode);

        return new SuccessResult("Kullanıcı aktif edildi");
    }
}
