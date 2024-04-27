package hibernate_one_to_many_bi_directional.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {
	
	@Id
	private int id ;
	private String name ;
	private int age;
	private String email;
	
	public Trainer(int id, String name, int age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	@OneToMany(mappedBy = "trainer")
	private List<Trainee> trainees ;

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
}
