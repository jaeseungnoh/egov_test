package egovframework.sample.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SampleServiceClient {
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext container = new GenericXmlApplicationContext("egovframework/spring/context-*.xml");
		
		SampleService sampleService = (SampleService)container.getBean("sampleService");
		SampleVO vo = new SampleVO();
		vo.setTitle("임시제목");
		vo.setRegUser("테스터");
		vo.setContent("임시내용");
		sampleService.insertSample(vo);
		
		List<SampleVO> sampleList = sampleService.selectSampleList(vo);
		System.out.println("[Sample List]");
		for(SampleVO sample : sampleList) {
			System.out.println("--> " + sample.toString());
		}
				
		container.close();
	}
	

}
