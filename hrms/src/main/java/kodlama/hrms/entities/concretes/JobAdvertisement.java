package kodlama.hrms.entities.concretes;



import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Future;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;


	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	
	
	@NotNull
	@Column(name="description",length = 3000)
	private String description;
	
	@Column(name="salary_max")
	private String salary_max;
	
	@Column(name="salary_min")
	private String salary_min;
	
	@Column(name="is_open",columnDefinition = "boolean Default true")
	private boolean isOpen=true;
	
	@JsonIgnore
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name="published_at")
	@NotNull
	private Date publishedAt;
	
	@Future
	@NotNull
	@CreationTimestamp
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name="deadline")
	private Date deadLine;
}
