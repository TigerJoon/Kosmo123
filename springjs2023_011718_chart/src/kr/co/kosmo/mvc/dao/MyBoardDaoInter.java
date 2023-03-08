package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.co.kosmo.mvc.vo.BoardDemoVO;
import kr.co.kosmo.mvc.vo.PagingDTO;

public interface MyBoardDaoInter {

	public void addBoard(BoardDemoVO vo);
	public List<BoardDemoVO> listBoard(Map<String, Integer> map);
	public int genCnt();
	public List<BoardDemoVO> getSearchList(PagingDTO vo);
	public int genCnt2(PagingDTO vo);
	public BoardDemoVO detailBoard(int num);
	public void delBoard(int num);
	
}
