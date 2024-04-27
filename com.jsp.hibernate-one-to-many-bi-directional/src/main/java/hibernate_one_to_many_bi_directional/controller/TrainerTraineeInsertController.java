package hibernate_one_to_many_bi_directional.controller;

import java.util.Arrays;
import java.util.List;

import hibernate_one_to_many_bi_directional.dao.TraineeDao;
import hibernate_one_to_many_bi_directional.dao.TrainerTraineeDao;
import hibernate_one_to_many_bi_directional.dto.Trainee;
import hibernate_one_to_many_bi_directional.dto.Trainer;

public class TrainerTraineeInsertController {

	public static void main(String[] args) {
		TrainerTraineeDao trainerTraineeDao = new TrainerTraineeDao();
		
		Trainer trainer = new Trainer(777, "shiv", 227, "jasota");
		
		Trainee trainee1 = new  Trainee(104, "anirudh", "modinagar", 18723354, trainer);

		Trainee trainee2 = new Trainee(105, "cheetah", "jungle", 72316451, trainer);
		
		Trainee trainee3 = new Trainee(106, "sherni", "jungle", 27532523, trainer);
		
//		List<Trainee> trainees = new ArrayList<Trainee>();
		List<Trainee> trainees =  Arrays.asList(trainee1, trainee2, trainee3); 

		
		trainerTraineeDao.saveTrainerTraineeDao(trainer, trainees);
	}
	
	
}
