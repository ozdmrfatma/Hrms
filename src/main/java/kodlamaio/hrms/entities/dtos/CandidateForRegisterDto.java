package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForRegisterDto {
	private String email;
	private String password;
	private String passwordAgain;
	private String firstName;
	private String lastName;
	private String identityNumber;
	private LocalDate dateOfBirth;

}
