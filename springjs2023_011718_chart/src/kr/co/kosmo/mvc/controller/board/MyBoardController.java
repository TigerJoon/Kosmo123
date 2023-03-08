package kr.co.kosmo.mvc.controller.board;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MyBoardDaoInter;
import kr.co.kosmo.mvc.vo.BoardDemoVO;
import kr.co.kosmo.mvc.vo.PagingDTO;


@Controller
@RequestMapping("/board") // 대분류
public class MyBoardController {
	
	@Autowired
	private MyBoardDaoInter myBoardDaoInter;
	
	//-------------------------------------------------------------
	// Page처리를 위한 속성
	private int nowPage = 1; // 현재 페이지 값 -> 메뉴 페이지와 연동되는 변수
	private int nowBlock = 1; // 현재 블럭 -> [][][][][] -> 1block당 5개  배열 생성
	private int totalRecord; // 총 게시물 수 .Dao로 부터 받음
	private int numPerPage = 10; // 한 페이지당 보여질 게시물 수
	private int pagePerBlock = 5; // 한 블럭당 보여질 페이지 수
	private int totalPage;  // 전체 페이지 수 => totalRecord/numPerPage
	private int totalBlock; // 전체 블럭수
	private int beginPerPage; // 각 페이지별 시작 게시물의 index값
	private int endPerPage; // 각 페이지별 마지막 게시물의 index값
	//-------------------------------------------------------------
	
	@GetMapping(value = "boardForm")
	public ModelAndView boardForm() {
		ModelAndView mav = new ModelAndView("board/boardForm");
		return mav;
	}
	
	@PostMapping(value = "/boardIn")
	public String boardIn(BoardDemoVO vo){
		System.out.println("subject => " +vo.getSubject());
		myBoardDaoInter.addBoard(vo);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping("/boardList")
	public ModelAndView listBoard(String cPage, PagingDTO vo) {
		ModelAndView mav = new ModelAndView("board/boardList");
				
		PagingDTO pvo = new PagingDTO();

		totalRecord = myBoardDaoInter.genCnt2(pvo);
		totalPage = (int)Math.ceil(totalRecord / (double) numPerPage);
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		String s_page =cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage-1) + numPerPage;
		
		pvo.setBegin(beginPerPage);
		pvo.setEnd(endPerPage);
		List<BoardDemoVO> list = myBoardDaoInter.getSearchList(pvo);
		
		int startPage = (int)((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		mav.addObject("list", list);
		mav.addObject("searchType", vo.getSearchType());
		mav.addObject("searchValue", vo.getSearchValue());
		mav.addObject("nowPage", nowPage);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("pagePerBlock", pagePerBlock);
		mav.addObject("totalPage", totalPage);
		
		return mav;
	}
	@GetMapping(value = "/boardDetail")
	public ModelAndView detailBoard(int num) {
		ModelAndView mav = new ModelAndView("board/boardDetail");
		BoardDemoVO vo = myBoardDaoInter.detailBoard(num);
		mav.addObject("vo", vo);
		return mav;
	}
	@GetMapping(value = "/boardDelete")
	public ModelAndView deleteBoard(int num) {
		ModelAndView mav = new ModelAndView("redirect:/board/boardList");
		myBoardDaoInter.delBoard(num);
		return mav;
	}
	
}
