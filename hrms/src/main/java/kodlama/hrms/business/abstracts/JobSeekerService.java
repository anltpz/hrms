package kodlama.hrms.business.abstracts;


import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
		Result add(JobSeeker jobSeeker);
		Result register(JobSeeker register);
		DataResult<List<JobSeeker>> getAll();
		
}
