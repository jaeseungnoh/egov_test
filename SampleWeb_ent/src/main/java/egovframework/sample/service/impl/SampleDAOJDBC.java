package egovframework.sample.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleVO;
import egovframework.sample.service.common.JDBCUtil;

@Repository("daoJDBC")
public class SampleDAOJDBC implements SampleDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID, TITLE, REG_USER, CONTENT, REG_DATE) VALUES((SELECT NVL(MAX(ID)), 0)+1 FROM SAMPLE), ?, ?, ?, SYSDATE)";
	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?, REG_USER, CONTENT? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET    = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_LIST   = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE ORDER BY REG_DATE DESC";
	
	public SampleDAOJDBC() {
		System.out.println("SampleDAOJDBC 생성");
	}
	
	public void insertSample(SampleVO vo) throws Exception{
		System.out.println("SampleDAOJDBC로 insertSample 처리");
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_INSERT);
		stmt.setString(1, vo.getTitle());
		stmt.setString(2, vo.getRegUser());
		stmt.setString(3, vo.getContent());
		stmt.executeUpdate();
		JDBCUtil.close(stmt, conn);
	}
	
	public void updateSample(SampleVO vo) throws Exception{
		System.out.println("SampleDAOJDBC로 updateSample 처리");
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_UPDATE);
		stmt.setString(1, vo.getTitle());
		stmt.setString(2, vo.getRegUser());
		stmt.setString(3, vo.getContent());
		stmt.setInt(4,  vo.getId());
		stmt.executeUpdate();
		JDBCUtil.close(stmt, conn);
	}
	
	public void deleteSample(SampleVO vo) throws Exception{
		System.out.println("SampleDAOJDBC로 deleteSample 처리");
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_DELETE);
		stmt.setInt(1, vo.getId());
		stmt.executeUpdate();
		JDBCUtil.close(stmt, conn);
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception{
		System.out.println("SampleDAOJDBC로 selectSample 처리");
		SampleVO sample = null;
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_GET);
		stmt.setInt(1, vo.getId());
		rs = stmt.executeQuery();
		if(rs.next()) {
			sample = new SampleVO();
			sample.setId(rs.getInt("ID"));
			sample.setTitle(rs.getString("TITLE"));
			sample.setRegUser(rs.getString("REG_USER"));
			sample.setContent(rs.getString("CONTENT"));	
			sample.setRegDate(rs.getDate("REG_DATE"));
		}
		JDBCUtil.close(rs, stmt, conn);
		return sample;
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception{
		System.out.println("SampleDAOJDBC로 selectSampleList 처리");
		List<SampleVO> sampleList = new ArrayList<SampleVO>();
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_LIST);
		System.out.println("SampleDAOJDBC : selectSampleList 0");
		rs = stmt.executeQuery();
		System.out.println("SampleDAOJDBC : selectSampleList 1");
		if(rs.next()) {
			SampleVO sample = new SampleVO();
			sample.setId(rs.getInt("ID"));
			sample.setTitle(rs.getString("TITLE"));
			sample.setRegUser(rs.getString("REG_USER"));
			sample.setContent(rs.getString("CONTENT"));	
			sample.setRegDate(rs.getDate("REG_DATE"));
			sampleList.add(sample);
		}
		System.out.println("SampleDAOJDBC : selectSampleList 2");
		JDBCUtil.close(rs, stmt, conn);
		System.out.println("SampleDAOJDBC : selectSampleList 완료");
		return sampleList;
	}

}
