package hibernate_one_to_many_bi_directional.controller;

import hibernate_one_to_many_bi_directional.dao.TraineeDao;
import hibernate_one_to_many_bi_directional.dto.Trainer;

public class getTrainerByTraineeId {

	public static void main(String[] args) {
		
		Trainer trainer = new TraineeDao().getTrainerByTraineeId(101);
		System.out.println(trainer);

	}

}
