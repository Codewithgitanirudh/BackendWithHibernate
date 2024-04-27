package hibernate_one_to_many_bi_directional.dto;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trainee {
	
	@Id
	private int id ;
	private String name ;
	private String address;
	private long phone;
	
	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private Trainer trainer;

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", trainer="
				+ trainer + "]";
	}
	
}
