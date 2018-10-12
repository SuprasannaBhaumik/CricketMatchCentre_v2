package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.study.dto.ScorecardDTO;
import com.study.messaging.ScorecardStreamingSource;

@RestController
public class PublishScorecardController {
	
	@Autowired
	ScorecardStreamingSource scorecardStream; 
	
	@RequestMapping(value="/publishScorecard", method=RequestMethod.POST)
	public void pushScorecard(@RequestBody ScorecardDTO scorecard) {
        scorecardStream.dispatchScorecard().send(MessageBuilder.withPayload(scorecard).build());
	}

}
