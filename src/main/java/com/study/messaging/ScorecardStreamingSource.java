package com.study.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ScorecardStreamingSource {
	
	@Output("xyz")
	MessageChannel dispatchScorecard();

}
