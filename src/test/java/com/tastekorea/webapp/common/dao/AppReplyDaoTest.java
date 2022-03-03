package com.tastekorea.webapp.common.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.tastekorea.webapp.TasteTest;
import com.tastekorea.webapp.common.Constants;
import com.tastekorea.webapp.common.domain.AppReply;
import com.tastekorea.webapp.member.domain.TasteMember;

public class AppReplyDaoTest extends TasteTest{
   
   @Autowired
   private AppReplyDao appReplyDao;
   
   
   @Test
   @Transactional
   public void saveReply() {
      start("saveReply");
      
      AppReply reply = new AppReply();
      reply.setParentId(0L);
      reply.setMember(new TasteMember(15000001));
      reply.setAppCode(Constants.PIN_ALBUM);
      reply.setComment("I like it!");
      reply.setRecipient(null);
      reply.setPriority(100);
      reply.setLikeCount(0);
      reply.setDislikeCount(0);

      long id = appReplyDao.saveReply(reply);
      System.out.println("id = " + id);
      
      end();
   }
   
   
   @Test
   public void findParentRepliesByAppCode() {
      start("findParentRepliesByAppCode");
      
      int appCode = Constants.PIN_ALBUM;
      Pageable pageable = PageRequest.of(0, 3, Direction.DESC, "regDate");
      Page<AppReply> page = appReplyDao.findParentRepliesByAppCode(appCode, pageable);
      for(AppReply r : page.getContent()) {
         System.out.println(r.getId());
      }
      
      end();
   }
}