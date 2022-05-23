package egovframework.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleVO;

@Repository("daoIBatis")
public class SampleDAOIBatis  implements SampleDAO{

	public SampleDAOIBatis() {
		System.out.println("SampleDAOIBatis 생성");
	}
	
	public void insertSample(SampleVO vo) throws Exception{
		System.out.println("SampleDAOIBatis로 insertSample 처리");
	}
	
	public void updateSample(SampleVO vo) throws Exception{
		System.out.println("SampleDAOIBatis로 updateSample 처리");
	}
	
	public void deleteSample(SampleVO vo) throws Exception{
		System.out.println("SampleDAOIBatis로 deleteSample 처리");
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception{
		System.out.println("SampleDAOIBatis로 selectSample 처리");
		return null;
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception{
		System.out.println("SampleDAOIBatis로 selectSampleList 처리");
		return null;
	}
}
