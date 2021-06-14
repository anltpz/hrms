package kodlama.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

	JobSeeker findByEmail(String email);
	JobSeeker findByIdentityNumber(String number);
	JobSeeker getById(int id);
}
