package egovframework.sample.web;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.sample.service.SampleVO;
//import egovframework.sample.service.impl.SampleDAOJDBC;
import egovframework.sample.service.SampleService;

@Controller
public class SampleController{
	@Resource(name = "sampleService")
	private SampleService sampleService;

	@RequestMapping(value="/insertSample.do")
	public String insertSample(SampleVO vo) throws Exception{
		System.out.println("inserSample.do");
		sampleService.insertSample(vo);
		return "forward:selectSampleList.do";
	}
	
	@RequestMapping(value="/updateSample.do")
	public String updateSample(SampleVO vo) throws Exception{
		sampleService.updateSample(vo);
		return "forward:selectSampleList.do";
	}

	@RequestMapping(value="/deleteSample.do")
	public String deleteSample(SampleVO vo) throws Exception{
		sampleService.deleteSample(vo);
		return "forward:selectSampleList.do";
	}
	
	@RequestMapping(value="/selectSample.do")
	public ModelAndView selectSample(SampleVO vo,  ModelAndView mav) throws Exception{
		System.out.println("selectSample.do");
		mav.addObject("sample", sampleService.selectSample(vo));
		mav.setViewName("selectSample");
		return mav;
	}
	
	@RequestMapping(value="/selectSampleList.do")
	public ModelAndView selectSampleList(SampleVO vo, ModelAndView mav) throws Exception{
		System.out.println("selectSampleList.do");
		mav.addObject("sampleList", sampleService.selectSampleList(vo));
		mav.setViewName("selectSampleList");
		return mav;
	}
	
}


/*
@Override
public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
	System.out.println("샘플 목록 검색 처리");
	
	//1. 사용자 입력 정보 추출
	
	//2. DB 연동 처리
	SampleVO vo = new SampleVO();
	SampleDAOJDBC sampleDAO = new SampleDAOJDBC();
	List<SampleVO> sampleList = sampleDAO.selectSampleList(vo);
	
	//3. 검색결과를 세션에 저장하고 목록 화면으로 이동
	
	HttpSession session = request.getSession();
	session.setAttribute("sampleList", sampleList);
	
	ModelAndView mav = new ModelAndView();
	mav.setViewName("selectSampleList.jsp");
	return mav;
}*/
