package com.tastekorea.webapp.pin.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 지도api에 담길 Pin 정보
 * 
 * 
 * @author "rohyh"
 *
 */
@Getter
@Setter
@Entity
public class PinMapData extends CommonEntity {
	
	// ------------------------
	//	해당 Pin 정보
	// ------------------------
	@OneToOne
	private Pin pin;
	
	// ------------------------
	//	좌표값
	// ------------------------
	private Pin coordinate;

	public PinMapData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PinMapData(long id) {
		this.id = id;
	}
	
	public PinMapData(Pin pin, Pin coordinate) {
		super();
		this.pin = pin;
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "PinMapData [pin=" + pin.getId() + ", coordinate=" + coordinate + "]";
	}
	
	
}
