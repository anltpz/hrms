package kodlama.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name = "job_seekers")
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "users_id")
public class JobSeeker  extends User{

	@NotBlank(message = "First Name Boş Olamaz")
	@Column(name ="first_name")
	private String firstName;
	
	@NotBlank(message = "Last Name Boş olamaz")
	@Column(name ="last_name" )
	private String lastName;

	
	@Column(name = "birthday")
	private LocalDate birthday;
	
	@Size(min = 11, max = 11, message = "İdentity 11 Harften Oluşmalıdır")
	@Column(name = "identity_number")
	private String identityNumber;

	
	
}
