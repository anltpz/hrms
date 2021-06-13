package kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.hrms.business.abstracts.JobPositionService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.ErrorResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.JobPositionDao;
import kodlama.hrms.entities.concretes.JobPosition;
@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Listeleme Başarılı");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (this.jobPositionDao.getByTitle(jobPosition.getTitle())==null) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Kayıt olundu");
		}
		else {
			return new ErrorResult("İş posizyonu sistemde kayıtlı");
		}
		
	}

}
