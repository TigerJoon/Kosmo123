package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

public interface MemberDaoInter {
	public void addMember(MemberDTO dto);
	public int idcheck(String id);
	// 아이디와 비번을 vo로 전송하고 반환값으로 id, name등을 반환
	public MemberDTO loginCheck(MemberDTO vo);
	// login로깅 처리를 위한 메서드
	public void addLoginLogging(MyLoginLoggerDTO vo);
	// json
	public MemberDTO jsonDemo(String id);
	public List<MemberDTO> memberList();
}
