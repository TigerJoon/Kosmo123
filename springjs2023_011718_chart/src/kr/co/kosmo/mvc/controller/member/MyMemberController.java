package kr.co.kosmo.mvc.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

@Controller
@RequestMapping("/member")
public class MyMemberController {
	@Autowired
	private MemberDaoInter memberDaoInter;
	
	@GetMapping(value = "/memberForm")
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView("mymember/memberForm");
		return mav;
	}
	// 반환형이 String 일 경우에는 viewName 전달,  Model인자로 보낼 수 있다
	@PostMapping(value = "/memberIn")
	public String memberIn(MemberDTO dto) {
		System.out.println("ID: "+dto.getId());
		System.out.println("age : "+dto.getAge());
		System.out.println("pwd: "+dto.getPwd());
		System.out.println("name: "+dto.getName());
		System.out.println("gender:" +dto.getGender());
		
		// 인터페이스를 사용한 입력 메서드 호출!
		memberDaoInter.addMember(dto);
		
		// 회원가입이 끝나고 나면 이동할 페이지 설정 - redirect
		return "redirect:/web/main"; 
	}

	
}
