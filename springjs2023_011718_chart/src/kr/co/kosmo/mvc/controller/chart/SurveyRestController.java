package kr.co.kosmo.mvc.controller.chart;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.surveyService;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@RestController
public class SurveyRestController {
	
	@Autowired
	private surveyService surveyService;
	/*
	 * {"num":21,"sub":"������������","code":0,"sdate":"2023-01-18 14:35:07","surveytotal"
	 * :0,"subvey":[
	 * {"subtype":"A    ","subcode":0,"surveytitle":"�񰡿ɴϴ�","surveycnt":500,"surveytotal":0},
	 * {"subtype":"B    ","subcode":0,"surveytitle":"�ȿɴϴ�","surveycnt":200,"surveytotal":0},
	 * {"subtype":"C    ","subcode":0,"surveytitle":"�𸨴ϴ�","surveycnt":666,"surveytotal":0}
	 * ,{"subtype":"D    ","subcode":0,"surveytitle":"��ǳ�̿ɴϴ�","surveycnt":54,"surveytotal":0},
	 * {"subtype":"E    ","subcode":0,"surveytitle":"���ɾ���","surveycnt":120,"surveytotal":0}]}
	 *	
	 * chart
	 * */
	
	@RequestMapping(value = "/surveyJsonObjDemo1")
	public SurveyVO surveyDetil(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		return vo;
	}
	// Map���� ��ȯ �ؼ� �ʿ��� �͸� ����Ѵ�
	@RequestMapping(value = "/surveyJsonObj", produces = "application/json;charset=utf-8")
	public Map<String, Integer> surveyDetilJson(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		// Key,Val => Map
		Map<String, Integer> map = new HashedMap();
		for(SurveyContentVO e : vo.getSubvey()) {
			//"�񰡿ɴϴ�" : 500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		return map;
	}
	// Map���� ��ȯ�� json�����Ϳ� title�� �Բ� ������....
	// 
	@RequestMapping(value = "/surveyJsonObj2", produces = "application/json;charset=utf-8")
	public String surveyDetilTitleJson(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		String subject = vo.getSub();
		// Key,Val => Map
		Map<String, Integer> map = new HashedMap();
		for(SurveyContentVO e : vo.getSubvey()) {
			//"�񰡿ɴϴ�" : 500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		// json ����� ���ڿ��� ��ȯ
		String result = null;
		//ObjectMapper ��ü�� ������ ��ȯ �� �� �ִ�.
		ObjectMapper mapper = new ObjectMapper();
		try {
			//map->{"�𸨴ϴ�":666,......"�� �ɴϴ�":501}
			result = mapper.writeValueAsString(map);
			//[{"sub":"���� ������ ����?"},map]
			result = "[{\"sub\":\""+vo.getSub()+"\"},"+result+"]";
			System.out.println(result);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return result;
	}
}
