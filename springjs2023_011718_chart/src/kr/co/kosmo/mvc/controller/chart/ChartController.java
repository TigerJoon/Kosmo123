package kr.co.kosmo.mvc.controller.chart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/mychart")
public class ChartController {
	
	
	@GetMapping(value = "deptJsonDemo")
	public String deptJson() {
		return "chart/deptJsonDemo";
	}
	@GetMapping(value = "memberListJsonDemo")
	public String memberListJson() {
		return "chart/memberListJsonDemo";
	}

	@GetMapping(value = "/student")
	public ModelAndView student() {
		ModelAndView mav = new ModelAndView("chart/ex5_customJsonStudent");
		return mav;
	}
	@GetMapping(value = "/donut")
	public ModelAndView student2() {
		ModelAndView mav = new ModelAndView("chart/donut");
		return mav;
	}
	@GetMapping(value = "/donut2")
	public ModelAndView student3() {
		ModelAndView mav = new ModelAndView("chart/donut2");
		return mav;
	}
	@GetMapping(value = "/surveyDonutChartAjax")
	public String chart3() {
		return "chart/surveyDonutChartAjax";
	}
	@GetMapping(value = "/surveyDonutChartAjaxTitle")
	public String charttitle(Model model, int num) {
		model.addAttribute("num",num);
		return "chart/surveyDonutChartAjaxTitle";
	}
}
