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
@RequestMapping("/board") // ��з�
public class MyBoardController {
	
	@Autowired
	private MyBoardDaoInter myBoardDaoInter;
	
	//-------------------------------------------------------------
	// Pageó���� ���� �Ӽ�
	private int nowPage = 1; // ���� ������ �� -> �޴� �������� �����Ǵ� ����
	private int nowBlock = 1; // ���� �� -> [][][][][] -> 1block�� 5��  �迭 ����
	private int totalRecord; // �� �Խù� �� .Dao�� ���� ����
	private int numPerPage = 10; // �� �������� ������ �Խù� ��
	private int pagePerBlock = 5; // �� ���� ������ ������ ��
	private int totalPage;  // ��ü ������ �� => totalRecord/numPerPage
	private int totalBlock; // ��ü ����
	private int beginPerPage; // �� �������� ���� �Խù��� index��
	private int endPerPage; // �� �������� ������ �Խù��� index��
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
