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
	 * {"num":21,"sub":"날씨설문조사","code":0,"sdate":"2023-01-18 14:35:07","surveytotal"
	 * :0,"subvey":[
	 * {"subtype":"A    ","subcode":0,"surveytitle":"비가옵니다","surveycnt":500,"surveytotal":0},
	 * {"subtype":"B    ","subcode":0,"surveytitle":"안옵니다","surveycnt":200,"surveytotal":0},
	 * {"subtype":"C    ","subcode":0,"surveytitle":"모릅니다","surveycnt":666,"surveytotal":0}
	 * ,{"subtype":"D    ","subcode":0,"surveytitle":"태풍이옵니다","surveycnt":54,"surveytotal":0},
	 * {"subtype":"E    ","subcode":0,"surveytitle":"관심없음","surveycnt":120,"surveytotal":0}]}
	 *	
	 * chart
	 * */
	
	@RequestMapping(value = "/surveyJsonObjDemo1")
	public SurveyVO surveyDetil(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		return vo;
	}
	// Map으로 반환 해서 필요한 것만 출력한다
	@RequestMapping(value = "/surveyJsonObj", produces = "application/json;charset=utf-8")
	public Map<String, Integer> surveyDetilJson(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		// Key,Val => Map
		Map<String, Integer> map = new HashedMap();
		for(SurveyContentVO e : vo.getSubvey()) {
			//"비가옵니다" : 500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		return map;
	}
	// Map으로 반환한 json데이터와 title을 함께 보내기....
	// 
	@RequestMapping(value = "/surveyJsonObj2", produces = "application/json;charset=utf-8")
	public String surveyDetilTitleJson(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		String subject = vo.getSub();
		// Key,Val => Map
		Map<String, Integer> map = new HashedMap();
		for(SurveyContentVO e : vo.getSubvey()) {
			//"비가옵니다" : 500
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		// json 결과를 문자열로 반환
		String result = null;
		//ObjectMapper 객체를 가지고 변환 할 수 있다.
		ObjectMapper mapper = new ObjectMapper();
		try {
			//map->{"모릅니다":666,......"비가 옵니다":501}
			result = mapper.writeValueAsString(map);
			//[{"sub":"내일 날씨는 어떨까요?"},map]
			result = "[{\"sub\":\""+vo.getSub()+"\"},"+result+"]";
			System.out.println(result);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return result;
	}
}
