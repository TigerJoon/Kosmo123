package kr.co.kosmo.mvc.controller.chart;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.SimpleDate;
import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

// @Controller -> ������ ���׾�ʰ� Model�� �����ؼ�
// ���� �ý��ۿ����� InternalResourceViewResolver�� ���ؼ� ������
// View �� forward ������� �̵��Ѵ�.
// @RestController -> CustomView�� ����ؼ� ������ View ��,
// JSP�� ������� �ʰ� �����͸� ������ �� �ֱ� ������
// �ַ� JSON���� response�� �� �ַ� �����
// @RestController : json �� ���� �����͸� ���� �ϱ� ���� ��Ʈ�ѷ� �̴�
// @Controller : �޽��� ���� [�ȳ��ϼ���.jsp]�� ���� �� �����ϴ�.
@RestController
public class ChartRestController {
	@Autowired
	private MemberDaoInter memberDaoInter;
	// �ش� ��û�� ���� ���� View���ٰ� ��ȯ���� ���� �����ؼ� ���� ó���� ���ش�.
	// produces = "text/html;charset=euc-kr => Context-Type�� �����ϴ� �Ӽ�
	@RequestMapping(value = "/helloView", produces = "text/html;charset=euc-kr")
	public String viewMessage() {
		return "�ȳ��ϼ���";
	}
	// Json Object Type  -> javascript Object
	@RequestMapping(value = "/deptJsonView1", produces = "application/json;charset=utf-8")
	public MemberDTO jsonObjectDemo1(String id) {
		try {
			System.out.println("id => "+id);
			MemberDTO vo = memberDaoInter.jsonDemo(id);
			return vo;
		} catch (Exception e) {
			MemberDTO vo = new MemberDTO();
			vo.setName("����");
			return vo;
		}
		// �׽�Ʈ�� VO�� ������ �� ����
		/*MemberDTO vo = new MemberDTO();
		vo.setName("��浿");
		vo.setNum(1);
		vo.setAge(11);
		vo.setGender("����");
		vo.setId("bigdaddy");
		vo.setPwd("11");
		vo.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		// ��� Ȯ��
		// {"num":1,"id":"bigdaddy","pwd":"11","name":"��浿"
		// ,"age":11,"gender":"����","mdate":"2023-01-18"}
		 *
		 * */
		
	}
	//�������� ) ȸ�� ��ü�� ����ϴ� JsonView�� ����ÿ�.
	@RequestMapping(value= "/listJsonView",produces = "application/json;charset=utf-8")
	public List<MemberDTO> memberListJson(){

			List<MemberDTO> list = memberDaoInter.memberList();
			
			return list;
		
	}
}