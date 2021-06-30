package kodlama.hrms.entities.abstracts.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoobSeekerWithSchool {
		@NotBlank(message = "Last Name Boş olamaz")
		private String firstName;
		@NotBlank(message = "Last Name Boş olamaz")
		private String lastName;
		private String schoolName;
		
}
