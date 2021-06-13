package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Employer;

public interface EmployerService {

	Result register(Employer employer);
	Result add(Employer employer);
	DataResult<List<Employer>> getAll();
}
