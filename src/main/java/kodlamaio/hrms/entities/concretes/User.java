package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED) // inherit edildigi sinifa ozelliklerini aktarir
@NoArgsConstructor
@AllArgsConstructor

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Email
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
}


//tabloları olustur controller ' ı yap 8. gün req 4-5-6
//