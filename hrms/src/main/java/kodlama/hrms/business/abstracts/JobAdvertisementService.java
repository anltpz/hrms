package kodlama.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> findByPublishedAtDesc();
	DataResult<List<JobAdvertisement>> findByIsOpenTrue();
	DataResult<List<JobAdvertisement>> findByIsActiveFalseAndIsOpenTrue();
	DataResult<List<JobAdvertisement>> aktifIlanlariTariheGoreSiralama();
	Result pasifIlan1(int id);
	
}
