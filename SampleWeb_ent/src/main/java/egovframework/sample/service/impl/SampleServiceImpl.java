package egovframework.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleService;
import egovframework.sample.service.SampleVO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	//@Resource(name="daoSpring")
	@Resource(name="daoMyBatis")
	private SampleDAO sampleDAO;
	
	public SampleServiceImpl() throws Exception {
		System.out.println("SampleServiceImpl 생성");
	}
	
	public void insertSample(SampleVO vo) throws Exception {
		System.out.println("insertSample---Sample 생성");
		sampleDAO.insertSample(vo);
	}
	
	public void updateSample(SampleVO vo) throws Exception {
		System.out.println("insertSample---Sample 생성");
		sampleDAO.updateSample(vo);
	}
	
	public void deleteSample(SampleVO vo) throws Exception {
		System.out.println("insertSample---Sample 생성");
		sampleDAO.deleteSample(vo);
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception {
		System.out.println("selectSample---Sample 생성");
		return sampleDAO.selectSample(vo);
	}
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		System.out.println("insertSample---Sample 생성");
		return sampleDAO.selectSampleList(vo);
	}

}
