package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.EmployerService;
import kodlama.hrms.core.utilities.fakeMernisAdapter.FakeMernisService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.EmployerDao;
import kodlama.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	
	private EmployerDao employerDao;
	private FakeMernisService fakeMernis;
	
	


	public EmployerManager(EmployerDao employerDao, FakeMernisService fakeMernis
			) {
		super();
		this.employerDao = employerDao;
		this.fakeMernis = fakeMernis;
	}

	@Override
	public Result register(Employer employer) {
		if (employerDao.findByEmail(employer.getEmail())==null) {
			System.out.println("Email veri tabanında yoksa  ekle");
		
			String email = employer.getEmail();
			String[] emailSplit = email.split("@");
			if (!emailSplit[1].equals(employer.getWebAdress())) {
				System.out.println("Your e-mail address and domain do not match");
			}
			else {
				this.employerDao.save(employer);
				
				return new SuccessResult("Kayıt başarılı");
				
			}
			
			
		}
				
		
		return new ErrorResult("İşlem başarısız");
	}
	
	

	@Override
	public Result add(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Listeleme başarılı");
	}

}
