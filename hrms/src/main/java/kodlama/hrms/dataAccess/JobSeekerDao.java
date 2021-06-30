package kodlama.hrms.dataAccess;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.hrms.entities.abstracts.dto.JoobSeekerWithSchool;
import kodlama.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

	JobSeeker findByEmail(String email);
	JobSeeker findByIdentityNumber(String number);
	JobSeeker getById(int id);
	

	
//	  
//	  @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
//	  		+ "(p.id, p.productName, c.categoryName) "
//	  		+ "From Category c Inner Join c.products p")
//	  List<ProductWithCategoryDto> getProductWithCategoryDetails();
//	  
//	  //select p.productId,p.productName, c.categoryName  from Category c inner join Product p
//	  //on c.categoryId = p.categoryId
//	

	 @Query("Select new kodlama.hrms.entities.abstracts.dto.JoobSeekerWithSchool"
		  		+ "(j.firstName, j.lastName,c.schoolName) "
		  		+ "From CvSchool c Inner Join c.jobSeeker j")
	 	List<JoobSeekerWithSchool> getJoobSeekerWithSchool();
	
}
