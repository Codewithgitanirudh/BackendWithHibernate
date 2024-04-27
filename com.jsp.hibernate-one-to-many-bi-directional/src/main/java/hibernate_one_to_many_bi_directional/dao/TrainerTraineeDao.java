package hibernate_one_to_many_bi_directional.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_one_to_many_bi_directional.dto.Trainee;
import hibernate_one_to_many_bi_directional.dto.Trainer;

public class TrainerTraineeDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
    public Trainer saveTrainerTraineeDao(Trainer trainer, List<Trainee> trainees) {
    	
    	et.begin();
    	em.persist(trainer);
    	for (Trainee trainee : trainees) {
			em.persist(trainee);
		}
    	et.commit();
    	return trainer;
    }
    
    public void associateTrainerTraineeDao(int traineeId, int trainerId) {
    	String insertQuery = "insert into trainer_trainee(Trainer_id , trainees_id) values(?1 , ?2)";
    	
    	Query query = em.createNativeQuery(insertQuery);
    	
    	query.setParameter(1, trainerId);
    	query.setParameter(2, traineeId);
    	
    	et.begin();
    	query.executeUpdate();
    	et.commit();
    }
    
    public Trainee updateTraineeNameByTraineeId(int traineeId, String name) {
    	
    	Trainee trainee = em.find(Trainee.class, traineeId);
    	
    	if(trainee != null) {
    		String updateQuery = "UPDATE Trainee t SET name = :value WHERE id = :entityId";
    		
    		Query query = em.createNativeQuery(updateQuery, Trainee.class).setParameter("value", name).setParameter("entityId", traineeId);
    		
    		et.begin();
    		query.executeUpdate();
//    		em.merge(trainee);
    		trainee.setName(name);
    		et.commit();
    		
    		return trainee;
    	}
    	return null;
    }

}
