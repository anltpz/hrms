package kodlama.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.JobAdvertisementService;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.JobAdvertisementDao;
import kodlama.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao advertisementDao;

	public JobAdvertisementManager(JobAdvertisementDao advertisementDao) {
		super();
		this.advertisementDao = advertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.advertisementDao.save(jobAdvertisement);
		return new SuccessResult();
	}
	
	
}
