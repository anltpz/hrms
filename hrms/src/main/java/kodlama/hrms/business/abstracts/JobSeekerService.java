package kodlama.hrms.business.abstracts;


import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
		Result add(JobSeeker jobSeeker);
		Result register(JobSeeker register);
}
