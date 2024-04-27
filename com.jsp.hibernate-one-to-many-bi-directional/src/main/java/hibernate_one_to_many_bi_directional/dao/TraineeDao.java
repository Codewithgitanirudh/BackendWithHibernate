package hibernate_one_to_many_bi_directional.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_one_to_many_bi_directional.dto.Trainee;
import hibernate_one_to_many_bi_directional.dto.Trainer;

public class TraineeDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Trainee saveTraineeDao(Trainee trainee) {
		
		et.begin();
		em.persist(trainee);
		et.commit();
		
		return trainee;
	}
	
	public Trainee deleteTraineeById(int traineeId) {
		
		Trainee trainee = em.find(Trainee.class, traineeId);
		System.out.println(trainee);
		if(trainee!=null) {
			
			String deleteQuery = "delete t from Trainee t where t.id = ?1";
			
			 Query query = em.createNativeQuery(deleteQuery);
			 query.setParameter(1, traineeId);
			 
			 et.begin();
//			 query.executeUpdate();
			 em.remove(trainee);
			 et.commit();
			 
			 return trainee;
		}
		return null;
	}
	
	public Trainer getTrainerByTraineeId(int traineeId) {
		
		Trainee trainee = em.find(Trainee.class, traineeId);
		
		if(trainee!=null) {	
			
//			String selectQuery = "select trainer.* from trainer, trainee where trainee.trainer_id in trainer.id";
			String selectQuery = "SELECT t.* FROM trainer t JOIN trainee tr ON tr.trainer_id = t.id WHERE tr.id = :traineeId";
		    Query query = em.createNativeQuery(selectQuery, Trainer.class).setParameter("traineeId", traineeId);
		    
		    Trainer trainer = (Trainer) query.getSingleResult();
		    
		    return trainer;
		}
	  return null;
	}
	
	public List<Trainee> getAllTraineeByTrainerId(int trainerId){
		
		Trainer trainer = em.find(Trainer.class, trainerId);
		
		if(trainer!=null) {
			
			String selectQuery = "SELECT * FROM Trainee tr JOIN Trainer t ON tr.trainer_id = t.id WHERE t.id = :trainerId";
			Query query = em.createNativeQuery(selectQuery, Trainee.class).setParameter("trainerId", trainerId);
			
			@SuppressWarnings("unchecked")
			List<Trainee> trainees = query.getResultList();
			
			return trainees;
		}
		return null;
	}
	
}





