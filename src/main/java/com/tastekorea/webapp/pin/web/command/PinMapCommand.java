package com.tastekorea.webapp.pin.web.command;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author "rohyh"
 *
 */
@Getter
@Setter
public class PinMapCommand {
	
	private long pinId;
	private String coordinate;
}
