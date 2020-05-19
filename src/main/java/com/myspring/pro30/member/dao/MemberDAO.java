package com.myspring.pro30.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface MemberDAO {

	public List selectAllMemberList() throws DataAccessException;

}
