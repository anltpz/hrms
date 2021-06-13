package kodlama.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.JobSeekerService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping(value = "api/jobseekers")
public class JobSeekerController {
	
		private JobSeekerService jobSeekerService;

		@Autowired
		public JobSeekerController(JobSeekerService jobSeekerService) {
			super();
			this.jobSeekerService = jobSeekerService;
		}
		
		@PostMapping("/add")
		public Result add(@RequestBody @Valid JobSeeker jobSeeker)
		{
			
			return this.jobSeekerService.add(jobSeeker);
		}
		@PostMapping("/register")
		public Result register(@RequestBody @Valid JobSeeker jobSeeker)
		{
			
			return this.jobSeekerService.register(jobSeeker);
		}
		
		@GetMapping("getAll")
		public DataResult<List<JobSeeker>> getAll(){
			return this.jobSeekerService.getAll();
			
			
			
		}
	
	
}
