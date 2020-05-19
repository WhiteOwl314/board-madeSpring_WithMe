package com.myspring.pro30.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro30.member.dao.MemberDAO;
import com.myspring.pro30.member.vo.MemberVO;

@Service("memberService")
//Propagation: 전파 REQUIRED: 호출한 곳에서 별도의 트랜잭션이 
//설정되어 있지 않았다면 트랜잭션를 새로 시작한다.(새로운 연결을 생성하고 실행한다.) 
//만약, 호출한 곳에서 이미 트랜잭션이 설정되어 있다면 기존의 트랜잭션 내에서 로직을 실행한다.
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		return membersList;
	}

	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}

}
