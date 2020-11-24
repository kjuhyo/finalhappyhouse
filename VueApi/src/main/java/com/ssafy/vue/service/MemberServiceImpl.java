package com.ssafy.vue.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dao.MemberMapper;
import com.ssafy.vue.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		MemberDto a = sqlSession.getMapper(MemberMapper.class).login(memberDto);
		System.out.println(a);
		return a;
	}
	

	@Override
	public String getServerInfo() {
		return "사용자에게 전달하고 싶은 중요정보";
	}

}
