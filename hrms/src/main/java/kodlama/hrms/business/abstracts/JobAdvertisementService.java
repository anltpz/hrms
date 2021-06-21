package kodlama.hrms.business.abstracts;

import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
}
