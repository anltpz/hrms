package kodlama.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")

public class Employer  extends User {
	
	@NotBlank
	@Column(name = "web_adress")
	String  webAdress;
	
	@NotBlank
	@Size(min = 10,max = 11)
	@Column(name = "phone_number")
    String	phoneNumber;
	
	@NotBlank
	@Column(name = "company_name")
    String	companyName;
	
	@Column(name="is_confirmed",columnDefinition = "boolean default false")
	boolean isConfirmed;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisement;
}
