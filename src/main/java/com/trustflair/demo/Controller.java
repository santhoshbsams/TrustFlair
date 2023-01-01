package com.trustflair.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.json.JSONObject;
import org.json.simple.JSONValue;  

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private QuestionScoutsService questionScoutsService;

	@PostMapping(value="/questionscouts/save",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String saveQuestionScouts(@RequestBody String questionsCoutsJson) {
		questionScoutsService.saveQuestionScouts(questionsCoutsJson);
		return questionsCoutsJson;
	}

	@GetMapping(value="/questionscouts")
	public ResponseEntity getQuestionScoutsByTrackingId(@RequestParam String trackingId) {
		Optional<QuestionScoutsEntity> questionScoutsEntity = questionScoutsService.getQuestionScoutsByTrackingId(trackingId);
		if (questionScoutsEntity.isPresent()) {
			return new ResponseEntity<>(JSONValue.parse(questionScoutsEntity.get().getTrackingInfo()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

