package my.mini.project.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import my.mini.project.user.model.vo.User;

@Repository
public class UserDao {
	
	//회원가입
	public int insertUser(SqlSessionTemplate sqlSession, User u) {
		
		return sqlSession.insert("userMapper.insertUser",u);
	}
	
	//아이디 중복체크
	public int idCheck(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("userMapper.idCheck",userId);
	}
	
	//로그인
	public User loginUser(SqlSessionTemplate sqlSession, User u) {

		return sqlSession.selectOne("userMapper.loginUser",u);
	}
	
	//정보수정
	public int updateUser(SqlSessionTemplate sqlSession, User u) {
		
		return sqlSession.update("userMapper.updateUser",u);
	}
	
	//회원탈퇴
	public int deleteUser(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.delete("userMapper.deleteUser",userId);
	}




}
