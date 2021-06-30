package kodlama.hrms.business.concretes;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlama.hrms.business.abstracts.JobAdvertisementService;
import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.core.utilities.results.SuccessDataResult;
import kodlama.hrms.core.utilities.results.SuccessResult;
import kodlama.hrms.dataAccess.JobAdvertisementDao;
import kodlama.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao advertisementDao;
	
	
	@Autowired
	 JobAdvertisementManager(JobAdvertisementDao advertisementDao) {
		super();
		this.advertisementDao = advertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		jobAdvertisement.setActive(false);
		this.advertisementDao.save(jobAdvertisement);
		return new SuccessResult();
	}

	
	

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByPublishedAtDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	
	// Actif olan ilanları listeliyor
	@Override
	public DataResult<List<JobAdvertisement>> findByIsOpenTrue() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.findByIsOpenTrue());
	}

	
	//Burası admin tarafından kontrol edilecek
	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveFalseAndIsOpenTrue() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.findByIsActiveFalseAndIsOpenTrue(), "İlan yayınlandı Admin tarafından aktif edilmesi bekleniyor");
	}

	@Override
	public DataResult<List<JobAdvertisement>> aktifIlanlariTariheGoreSiralama() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.aktifIlanlariTariheGoreSiralama(), "İlanlar tarihe göre sıralandı");
	}
	@Transactional
	@Override
	public Result pasifIlan1(int id) {
		this.advertisementDao.pasifIlan(id);
		return new SuccessResult("Pasif başarılı");
		
	}

	
	

	

	
	
	
}
