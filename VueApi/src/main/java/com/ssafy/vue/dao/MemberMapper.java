package com.ssafy.vue.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.MemberDto;

@Mapper
public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public void update(MemberDto memberDto) throws SQLException;
	public void insert(MemberDto memberDto) throws SQLException;
	public void delete(MemberDto memberDto) throws SQLException;
	
}
