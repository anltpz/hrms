package kodlama.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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

	@Column(name ="first_name")
	private String firstName;
	
	@Column(name ="last_name" )
	private String lastName;

	@Column(name = "birthday")
	private Date birthday;

	
}
