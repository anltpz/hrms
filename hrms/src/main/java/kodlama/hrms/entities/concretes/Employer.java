package kodlama.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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
	
	
}
