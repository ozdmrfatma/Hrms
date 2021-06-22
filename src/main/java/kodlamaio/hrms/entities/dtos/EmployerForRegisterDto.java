package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {
	private String email;
	private String password;
	private String passwordAgain;
	private String companyName;
	private String webAddress;
	private String phoneNumber;
}
