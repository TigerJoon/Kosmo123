package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.BoardDemoVO;
import kr.co.kosmo.mvc.vo.PagingDTO;

@Repository
public class MyBoardDao implements MyBoardDaoInter{
	
	@Autowired
	private SqlSessionTemplate ss;
	@Override
	public void addBoard(BoardDemoVO vo) {
		ss.insert("myboard.add", vo);
	}

	@Override
	public BoardDemoVO detailBoard(int num) {
		BoardDemoVO vo = ss.selectOne("myboard.detail",num);
		return vo;
	}

	@Override
	public void delBoard(int num) {
		ss.delete("myboard.delete", num);
	}

	@Override
	public int genCnt() {
		return ss.selectOne("myboard.totalCount");
	}

	@Override
	public List<BoardDemoVO> listBoard(Map<String, Integer> map) {
		return ss.selectList("myboard.listpage", map);
	}

	@Override
	public List<BoardDemoVO> getSearchList(PagingDTO vo) {
		return ss.selectList("myboard.listSearchpage", vo);
	}

	@Override
	public int genCnt2(PagingDTO vo) {
		return ss.selectOne("myboard.totalCount2",vo);
	}

}
