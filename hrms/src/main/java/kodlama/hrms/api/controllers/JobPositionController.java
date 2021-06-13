package kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.JobPositionService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping(value = "api/jobposition")
public class JobPositionController {

	private JobPositionService jobPositionService;

	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	
	@GetMapping("/getall")
	public DataResult< List<JobPosition>> getAll()
	{
		
		return this.jobPositionService.getAll();
	}
	
	@PostMapping("/jobpositionAdd")
	public Result add (@RequestBody JobPosition jobPosition)
	{
		
		return this.jobPositionService.add(jobPosition);
	}
}
