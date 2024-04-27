package hibernate_one_to_many_bi_directional.controller;

import java.util.List;

import hibernate_one_to_many_bi_directional.dao.TraineeDao;
import hibernate_one_to_many_bi_directional.dto.Trainee;

public class getTraineeByTrainerId {

	public static void main(String[] args) {
		
		List<Trainee> trainee = new TraineeDao().getAllTraineeByTrainerId(999);
		
		for (Trainee trainee2 : trainee) {
			System.out.println(trainee2);
		}

	}

}
