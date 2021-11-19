package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.MemberDTO;
import mybatis.config.DBService;

public class MemberDAO {

	private SqlSessionFactory factory;
	private static MemberDAO instance;
	private MemberDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	private final String NAMESPACE = "dao.members";
	
	// 1. member list
	public List<MemberDTO> selectAllMember() {
		SqlSession ss = factory.openSession();
		List<MemberDTO> list = ss.selectList(NAMESPACE + ".selectAllMember");
		ss.close();
		return list;
	}
	
	
	// top list
	public List<MemberDTO> selectTop() {
		SqlSession ss = factory.openSession();
		List<MemberDTO> topMember = ss.selectList(NAMESPACE + ".selectTop");
		ss.close();
		return topMember;
	}
	
	
	// member delete
	public int deleteMember(Long no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(NAMESPACE + ".deleteMember", no);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// insert
	public int insertMember(MemberDTO memberDTO) {
		SqlSession ss = factory.openSession(false); // auto commit 
		int result = ss.insert(NAMESPACE + ".insertMember", memberDTO);
		
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	/* select for login
	public List<MemberDTO> loginMember(MemberDTO memberDTO) {
		
	}
	*/
	
	
}
