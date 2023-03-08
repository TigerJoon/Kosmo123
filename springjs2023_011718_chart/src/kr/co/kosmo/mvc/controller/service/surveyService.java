package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

// <context:component-scan base-package="kr.co.kosmo.mvc"/>
//@Service,@Repository,@Component �����Ͻ� ������ ��� �� �� �ִ�.

@Service
public class surveyService {
	//Dao�� ����ó�� �ϱ� ���� ����
	@Autowired
	private SurveyDao surveyDao;
	// �𵨿��� �޾ƿ� �� �����͸� Dao�� ���� �����ؼ� ����ó���� �ϱ� ���� �޼���
	
	//Transaction ó���� �ϱ� ���ؼ�
	// ����󿡼� ����  <tx:annotation-driven>, DataSourceTransactionManager di>
	@Transactional
	public void addSurveu(SurveyVO vo, List<SurveyContentVO> list) {
		// ����ó�� �ȵ�
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

