package com.segema.httpclient;

import java.time.LocalDateTime;

public class Parameter {
	// targetId
	private String targetId;

	// eventId
	private String eventId;

	// 完成时间
	private LocalDateTime finishTime;

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public LocalDateTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalDateTime finishTime) {
		this.finishTime = finishTime;
	}
}
