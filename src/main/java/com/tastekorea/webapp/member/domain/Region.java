package com.tastekorea.webapp.member.domain;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Region extends CommonEntity {
	private String kor;
	private String eng;
	private boolean guide;

	public Region() {
		super();
	}

	public Region(long id) {
		super.id = id;
	}

	public Region(String kor, String eng, boolean guide) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.guide = guide;
	}

	public Region(long id, String kor, String eng) {
		super();
		this.id = id;
		this.kor = kor;
		this.eng = eng;
	}

	public Region(String kor, String eng) {
		super();
		this.kor = kor;
		this.eng = eng;
	}

}