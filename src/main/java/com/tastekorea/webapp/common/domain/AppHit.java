package com.tastekorea.webapp.common.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 특정 리소스에 대한 조회수
 * @author Sage R Lee
 *
 */
@Entity
@Getter
@Setter
public class AppHit extends CommonEntity{
	private long resourceId;
	private int hit;
	private int appCode;
}