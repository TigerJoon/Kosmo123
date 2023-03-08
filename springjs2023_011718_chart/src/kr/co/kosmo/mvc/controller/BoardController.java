package kr.co.kosmo.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.vo.BoardDemoVO;
import kr.co.kosmo.mvc.vo.MemberDemoVO;

@Controller
public class BoardController {
	//1. boardForm
	
	//2. boardIn
	/*
	 * ModelAndView mav = new ModelAndView("redirect:boardlist");
	 * System.out.println("reip =>"+vo.getReip());
	 * System.out.println("title =>"+vo.getTitle());
	 * System.out.println("content =>"+vo.getContent());
	 *
	 * */
	/*
	 * 3. boardList List<boardVO> list = new ArrayList<boardVo>();
		임시데이터 만들어서 보내기
	 */
	@GetMapping(value = "/boardForm")
	public ModelAndView boardform() {
		ModelAndView mav = new ModelAndView("board/boardForm");
		return mav;
	}
	
	@PostMapping(value = "/boardIn")
	public ModelAndView addBoard(BoardDemoVO vo) {
		ModelAndView mav = new ModelAndView("board/boardList");
		System.out.println("reip =>"+vo.getReip());
		System.out.println("title =>"+vo.getTitle());
		System.out.println("content =>"+vo.getContent());		
		mav.addObject("vo",vo);
		return mav;
	}
	@GetMapping(value = "/boardlist")
	public ModelAndView listBoard(){
		List<BoardDemoVO> list = new ArrayList<BoardDemoVO>();
		ModelAndView mav = new ModelAndView("board/boardList");
		for (int i = 0; i < 10; i++) {
			BoardDemoVO vo = new BoardDemoVO();
			vo.setNum(i+1);
			vo.setTitle("전동준이다"+i);
			vo.setWriter("전동준");
			vo.setBdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			list.add(vo);	
		}
		mav.addObject("list",list);
		return mav;
	}
}
