package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;
// Dao���� @Repository ��� => Dao�� ������ ��Ͻ����ش�.
// �̱����̴�. �⺻��
@Repository
public class MemberDao implements MemberDaoInter {
	// kosmo-web.xml���� ������ bean byName
	@Autowired
	private SqlSessionTemplate ss;
	@Override
	public void addMember(MemberDTO dto) {
		ss.insert("member.add", dto);
	}
	@Override
	public int idcheck(String id) {
		return ss.selectOne("member.idchk", id);
	}
	@Override
	public MemberDTO loginCheck(MemberDTO vo) {
		return ss.selectOne("member.login",vo);
	}
	@Override
	public void addLoginLogging(MyLoginLoggerDTO vo) {
		ss.insert("member.logger_in",vo);
		
	}
	@Override
	public MemberDTO jsonDemo(String id) {
		return ss.selectOne("member.jsonDemo", id);
	}
	@Override
	public List<MemberDTO> memberList() {
		return ss.selectList("member.memberList");
	}


}
