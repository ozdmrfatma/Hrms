package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
public class Candidate extends User{

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank
	@NotNull
	@Size(min =11 ,max=11)
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidate")
	private List<CandidateVerification>candidateVerifications;
}
