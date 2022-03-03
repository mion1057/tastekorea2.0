package com.tastekorea.webapp.pin.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.tastekorea.webapp.TasteTest;
import com.tastekorea.webapp.member.domain.Region;
import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinCategory;

public class PinDaoTest extends TasteTest {

	@Autowired
	private PinDao pinDao;

	@Test
	@Transactional
	@Commit
	public void save() {
		start("save");
		Pin pin = new Pin();
		pin.setMember(new TasteMember(15000001));
		pin.setRegion(new Region(10000001));
		pin.setCategory(new PinCategory(1000002));
		pin.setImagePath("12345");
		pin.setTitle("hi");
		pin.setDescription("good");
		pin.setMapData("35.861650150996475, 128.6061873250659");

		long id = pinDao.save(pin);
		System.out.println("id = " + id);

		end();
	}

	@Test
	public void findAllPin() {
		start("findAllPin");

		Pageable pageable = PageRequest.of(0, 3, Direction.DESC, "regDate");
		Page<Pin> page = pinDao.findAllPin(pageable);
		for (Pin pin : page.getContent()) {
			System.out.println(pin.getId());
		}

		end();
	}
	
	@Test
	public void findById() {
		start("findById");
		Pin pin = pinDao.findById(10000015);
		System.out.println(pin.getId());
		System.out.println(pin.getCategory().getEng());
		end();
	}
}
