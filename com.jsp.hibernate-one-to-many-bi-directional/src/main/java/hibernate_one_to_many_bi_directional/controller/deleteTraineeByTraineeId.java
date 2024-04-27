package hibernate_one_to_many_bi_directional.controller;

import hibernate_one_to_many_bi_directional.dao.TraineeDao;


public class deleteTraineeByTraineeId {

	public static void main(String[] args) {
		
		TraineeDao traineedao = new TraineeDao();
		traineedao.deleteTraineeById(102);
	

	}

}
