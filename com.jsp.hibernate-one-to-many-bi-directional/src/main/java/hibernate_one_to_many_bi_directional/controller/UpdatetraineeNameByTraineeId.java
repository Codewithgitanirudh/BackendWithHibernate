package hibernate_one_to_many_bi_directional.controller;

import hibernate_one_to_many_bi_directional.dao.TrainerTraineeDao;

public class UpdatetraineeNameByTraineeId {

	public static void main(String[] args) {
		
		TrainerTraineeDao trainerTraineeDao = new TrainerTraineeDao();
		trainerTraineeDao.updateTraineeNameByTraineeId(101, "Lion");
	}

}
