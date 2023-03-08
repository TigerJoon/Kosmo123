package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

// <context:component-scan base-package="kr.co.kosmo.mvc"/>
//@Service,@Repository,@Component 비지니스 로직을 담당 할 수 있다.

@Service
public class surveyService {
	//Dao를 단위처리 하기 위한 서비스
	@Autowired
	private SurveyDao surveyDao;
	// 모델에서 받아온 각 데이터를 Dao에 각각 전달해서 단위처리를 하기 위한 메서드
	
	//Transaction 처리를 하기 위해서
	// 공통빈에서 설정  <tx:annotation-driven>, DataSourceTransactionManager di>
	@Transactional
	public void addSurveu(SurveyVO vo, List<SurveyContentVO> list) {
		// 단위처리 안됨
		surveyDao.addSurvey(vo); //commitX
		surveyDao.addSurveyContent(list); //commitX
		//commit
	}
	
	public SurveyVO adminDetail(int num) {
		return surveyDao.adminDetail(num);
	}
	
	public void updateSurveyCnt(SurveyContentVO scvo) {
		surveyDao.updateSurveyCnt(scvo);
	}
	public List<SurveyVO> listSurvey(){
		return surveyDao.listSurvey();
	}
}

