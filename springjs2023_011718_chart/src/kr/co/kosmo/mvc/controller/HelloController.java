package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 생략 X
// HelloController는 예전에 모델에 해당이 된다.
// DispatcherServlet 란 컨트롤 서블릿이 스프링 컨테이너에 의해서 Model을 주입 받아서 실행
// HandlerMapping 이 요청 사항을 분석 해준다. ******
@Controller // 생략 X
public class HelloController {
	// http://localhost/spring2023_0103_mvc/hello (request) : 중복이 되면 안됨
	// ActionFactory --------> Spring Container ---------> DispatcherServlet
	// ------> HandlerMapping이 분석
	@RequestMapping(value="/hello")
	public ModelAndView myHello() {
		ModelAndView mav = new ModelAndView();
		//request.setAttribute("key",Val);
		mav.addObject("msg", "<h1>안녕하세요2. 나의 첫번째 spring MVC 입니다.</h1>");
		// new ActionForward("hello.jsp",false);
		mav.setViewName("hello"); //  기본은 포워드임
		
		return mav;
	}
	@RequestMapping(value="/mypro")
	public ModelAndView myProfile() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pro","<h2>전동준의 프로필 입니다ㅑ.<h2/>");
		mav.setViewName("todayProfile");
		return mav;
	}
	
	@RequestMapping(value="/mywork")
	public ModelAndView myWork() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("work","<h1>저의 마이워크에요.<h2/>");
		mav.setViewName("todayWork");
		return mav;
	}
}
