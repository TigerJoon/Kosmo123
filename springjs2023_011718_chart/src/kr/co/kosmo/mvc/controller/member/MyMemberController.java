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
	// ��ȯ���� String �� ��쿡�� viewName ����,  Model���ڷ� ���� �� �ִ�
	@PostMapping(value = "/memberIn")
	public String memberIn(MemberDTO dto) {
		System.out.println("ID: "+dto.getId());
		System.out.println("age : "+dto.getAge());
		System.out.println("pwd: "+dto.getPwd());
		System.out.println("name: "+dto.getName());
		System.out.println("gender:" +dto.getGender());
		
		// �������̽��� ����� �Է� �޼��� ȣ��!
		memberDaoInter.addMember(dto);
		
		// ȸ�������� ������ ���� �̵��� ������ ���� - redirect
		return "redirect:/web/main"; 
	}

	
}
