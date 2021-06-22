package kodlamaio.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="employer_verifications")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "verification_code_id",referencedColumnName = "id")

public class EmployerVerification extends VerificationCode{
	
//
//	@Column(name="employer_id")
//	private int employerId;
//	
//	@Column(name="employee_confirm_id")
//	private int employeeConfirmId;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="employee_confirm_id")
	private EmployeeConfirm employeeConfirm;
	
}
