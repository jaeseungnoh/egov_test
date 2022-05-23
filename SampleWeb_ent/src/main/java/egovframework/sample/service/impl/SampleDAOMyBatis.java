package egovframework.sample.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;
import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleVO;

@Repository("daoMyBatis")
public class SampleDAOMyBatis extends EgovAbstractMapper implements SampleDAO{
	public SampleDAOMyBatis() {
		System.out.println("SampleDAOMyBatis 생성");
	}
	public void insertSample(SampleVO vo) throws Exception {
		System.out.println("MyBatis : insertSample");
		insert("insertSample", vo);
	}
	public void updateSample(SampleVO vo) throws Exception {
		System.out.println("MyBatis : updateSample");
		insert("updateSample", vo);
	}
	public void deleteSample(SampleVO vo) throws Exception {
		System.out.println("MyBatis : deleteSample");
		insert("deleteSample", vo);
	}
	public SampleVO selectSample(SampleVO vo) throws Exception {
		System.out.println("MyBatis : selectSample");
		return (SampleVO)selectOne("selectSample", vo);
	}
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		System.out.println("MyBatis : selectSampleList");
		return selectList("selectSampleList", vo);
	}
}
