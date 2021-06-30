package kodlama.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.hrms.business.abstracts.EmployerService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Employer;

@RestController
@RequestMapping(value = "api/employer")
public class EmployerController {

	
	private EmployerService empoloyerService;

	public EmployerController(EmployerService empoloyerService) {
		super();
		this.empoloyerService = empoloyerService;
	}
	@PostMapping("/register")
	public Result register(@RequestBody @Valid Employer employer)
	{
		
		return this.empoloyerService.register(employer);
	}
	
	
	@GetMapping("/getall")
	
	public DataResult<List<Employer>> getAll ()
	{
		
		return this.empoloyerService.getAll();
		
	}
	@GetMapping("/activeEmpolyer")
	
	public DataResult<List<Employer>> getActiveEmployer(){
		
		return this.empoloyerService.findByIsConfirmed(false);
	}
	
	
	
	
	
}
