package kodlamaio.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_verifications")
@EqualsAndHashCode(callSuper=false)		//böyle yapınca tekrar tekrar olusturmuyor.
@PrimaryKeyJoinColumn(name = "verification_code_id",referencedColumnName = "id")


public class CandidateVerification extends VerificationCode{
	
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
