package kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlama.hrms.business.abstracts.JobSeekerService;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.JobSeekerDao;
import kodlama.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İşlem başarılı");
	}

	
	
	

}
