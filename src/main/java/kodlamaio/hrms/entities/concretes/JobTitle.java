package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //data

@Entity //entity
@Table(name="job_titles")
@NoArgsConstructor //parametresiz conctructorları ayarlar
@AllArgsConstructor //allparameter conctructor

public class JobTitle  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id")
	private int id;
	
	@NotBlank(message = "İş pozisyonu boş bırakılamaz.")
	@NotNull
	@Column(name="title")
	private String title;
	
	
}
