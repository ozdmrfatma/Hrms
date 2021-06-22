package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
public class Employer extends User{
	
	@NotBlank(message = "Şirket adı boş bırakılamaz.")
	@NotNull
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message = "Web adresi boş bırakılamaz.")
	@NotNull
	@Column(name="web_address")
	private String webAddress;
	
	@NotBlank(message = "Telefon numarası boş bırakılamaz")
	@NotNull
	@Column(name="phone_number")
	private String phoneNumber;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "employer")
	private List<EmployerVerification>employerVerifications;
	

}
