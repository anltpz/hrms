package kodlama.hrms.api.controllers;


import java.util.List;import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlama.hrms.business.abstracts.JobAdvertisementService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping(value = "api/JobAdvertisement")
public class JobAdvertisementController {

	private static final Result SuccessResult = null;
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
	@GetMapping("/active")
	public DataResult<List<JobAdvertisement>> getAll(){
		
		
		return this.advertisementService.findByIsOpenTrue();
	}
	
	@GetMapping("/activeAdmin")
	public DataResult<List<JobAdvertisement>> onayBekleyenIlan(){
		
		
		return this.advertisementService.findByIsActiveFalseAndIsOpenTrue();
	}
	
	@GetMapping("/tariheGoreSıralama")
	public DataResult<List<JobAdvertisement>> tariheGoreSiralama(){
		
		
		return this.advertisementService.aktifIlanlariTariheGoreSiralama();
	}
	@PostMapping("/pasiIlanYapma")
	public Result add (@RequestParam @Param(value = "id") int id)
	{
		
	return this.advertisementService.pasifIlan1(id);
		
	}
	
	
}
