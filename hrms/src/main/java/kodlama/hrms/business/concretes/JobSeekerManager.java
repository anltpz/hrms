package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlama.hrms.business.abstracts.JobSeekerService;
import kodlama.hrms.business.abstracts.VerificationCodeService;
import kodlama.hrms.core.utilities.fakeMernisAdapter.FakeMernisService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.JobSeekerDao;
import kodlama.hrms.entities.abstracts.dto.JoobSeekerWithSchool;
import kodlama.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private FakeMernisService fakeMernis;
	private VerificationCodeService verificationService;


   @Autowired
   public JobSeekerManager(JobSeekerDao jobSeekerDao, FakeMernisService fakeMernis
			,VerificationCodeService verificationService ) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.fakeMernis = fakeMernis;
		this.verificationService=verificationService;
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
			
			
				jobSeekerDao.save(register);
					
				verificationService.codeAddUser(register.getId());
				
						
				
				
			
			return new SuccessResult("Kayıt Olunması Icın dogrulama kodu gonderıldı");
			
		}
		return new ErrorResult("Kayıt Olunamadı");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Listeleme Başarılı");
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JoobSeekerWithSchool>> getJoobSeekerWithSchool() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JoobSeekerWithSchool>>(this.jobSeekerDao.getJoobSeekerWithSchool(), "Okulu geldi");
	}



	
	
	

}
