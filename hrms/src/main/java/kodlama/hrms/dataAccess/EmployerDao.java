package kodlama.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer findByEmail(String email);
	
	List<Employer> findByIsConfirmed(boolean deger);

}
