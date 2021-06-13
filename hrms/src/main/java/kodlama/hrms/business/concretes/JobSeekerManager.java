package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlama.hrms.business.abstracts.JobSeekerService;
import kodlama.hrms.business.abstracts.VerificationService;
import kodlama.hrms.core.utilities.fakeMernisAdapter.FakeMernisService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorDataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.JobSeekerDao;
import kodlama.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private FakeMernisService fakeMernis;
	private VerificationService verificationService;



   @Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, FakeMernisService fakeMernis,
			VerificationService verificationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.fakeMernis = fakeMernis;
		this.verificationService = verificationService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if (jobSeekerDao.findByEmail(jobSeeker.getEmail())==null) {
			System.out.println("Sistemde email yok kayıt olunabilir");
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult("İşlem başarılı");
		}
		
		return new ErrorResult("İşlem Başarısız");
		
	}

	@Override
	public Result register(JobSeeker register) {
		if (jobSeekerDao.findByEmail(register.getEmail())==null && jobSeekerDao.findByIdentityNumber(register.getIdentityNumber())==null) {	
			fakeMernis.mernisCheck(register.getEmail());			
			verificationService.sendVerificationCode(register.getEmail());			
			jobSeekerDao.save(register);
			//Burada aktifligi false yazıcagım  ver tabanına yazmadım
			
			
			//1. adım email ve tc numarası veri tabanında varmmı kontorol et
			//2 .adım tc kimlik numarasını mernins sisteminde kontrol et dogruysa devam et
			//3. e posta adresine dogrulama kodu gönder
			//4. adım veri tabanındaki aktif useri false çek cünkü dogrulama kodu onaylanmadı sadece gönderildi
			return new SuccessResult("Kayıt Olundu");
			
		}
		return new ErrorResult("Kayıt Olunamadı");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Listeleme Başarılı");
	}

	
	
	

}
