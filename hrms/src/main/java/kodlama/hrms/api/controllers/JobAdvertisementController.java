package kodlama.hrms.api.controllers;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.JobAdvertisementService;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping(value = "api/JobAdvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService advertisementService;

	public JobAdvertisementController(JobAdvertisementService advertisementService) {
		super();
		this.advertisementService = advertisementService;
	}
	
	@PostMapping 
	public Result add (@RequestBody JobAdvertisement advertisement)
	{
		return this.advertisementService.add(advertisement); 
	}
}
