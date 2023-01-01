package com.trustflair.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@Table(name="question_scouts")
@TypeDef(name = "jsonb",typeClass = JsonBinaryType.class)
public class QuestionScoutsEntity {

	@Id
	@Column(name="tracking_id")
	private String trackingId;

	@Type(type = "jsonb")
	@Column(columnDefinition = "json" , name="tracking_info")
	private String trackingInfo;


	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getTrackingInfo() {
		return trackingInfo;
	}

	public void setTrackingInfo(String trackingInfo) {
		this.trackingInfo = trackingInfo;
	}

}
