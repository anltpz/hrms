package kodlama.hrms.dataAccess;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlama.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	
	 @Query("From JobAdvertisement where isOpen=true")// iş verenin acık ilanları
	  List<JobAdvertisement> getAllIsOpen();
	 
	 @Query("From JobAdvertisement where isOpen=true Order By publishedAt  ")
	 List<JobAdvertisement> findByPublishedAtAsc();
	
	 //acık ilanları listeleme 
	 List<JobAdvertisement> findByIsOpenTrue();
  // sadece boolean veri tiplerinde entityden gelen boolean verisinin sonuna true yada false yazarsak sorguyu direk getirir
	 // findBy/IsActive(entityden gelen  deger)/true yada false  
		
	// ilan yayınlanmıs fakat onay bekliyor admin görücek
	 List<JobAdvertisement> findByIsActiveFalseAndIsOpenTrue();
	 
	 // pasif ilan
	
	 @Modifying(flushAutomatically = true)
	 @Query("update JobAdvertisement j set j.isActive = false where j.id =:id")
	 void pasifIlan(@Param(value = "id") int id);
	 
	 // aktiflifi false olanları sil
	 @Modifying(flushAutomatically = true)
	 @Query("delete JobAdvertisement j where j.isActive = false")
	 List<JobAdvertisement> deleteAdvirsiment();

	 //aktif ilanları tarihe göre sıralama
	 @Query("From JobAdvertisement where isOpen = true Order By publishedAt Desc")
	List<JobAdvertisement> aktifIlanlariTariheGoreSiralama();

		
	 
	 	
	 
}
