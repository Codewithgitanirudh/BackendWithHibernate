package hibernate_one_to_many_bi_directional.controller;

import hibernate_one_to_many_bi_directional.dao.TraineeDao;
import hibernate_one_to_many_bi_directional.dao.TrainerTraineeDao;
import hibernate_one_to_many_bi_directional.dto.Trainee;

public class TrainneeInsertController {

	public static void main(String[] args) {
		
		TraineeDao dao = new TraineeDao();
		
		TrainerTraineeDao dao2 = new TrainerTraineeDao();
		
//		dao.saveTraineeDao(new Trainee(441, "yashendra", "malaysia", 652321));
		
//		dao2.associateTrainerTraineeDao(321, 999);
		
//		dao.deleteTraineeById(432);
		
	}

}
