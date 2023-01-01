package com.trustflair.demo;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.json.*;

@Service
public class QuestionScoutsService {

	@Autowired 
	private QuestionScoutsRepository questionScoutsRepository;
	
	@Transactional
	public void saveQuestionScouts(String questionsCoutsJson) {
		JSONObject jsonObject = new JSONObject(questionsCoutsJson);
		QuestionScoutsEntity questionScoutsEntity = new QuestionScoutsEntity();
		questionScoutsEntity.setTrackingId(jsonObject.getJSONObject("urlParams").get("tracking-id").toString());
		questionScoutsEntity.setTrackingInfo(jsonObject.toString());
		questionScoutsRepository.save(questionScoutsEntity);
	}
	
	public Optional<QuestionScoutsEntity> getQuestionScoutsByTrackingId(String trackingId) {
		return questionScoutsRepository.findById(trackingId);
	}
}
