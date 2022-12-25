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
	
	//로그인
	public User loginUser(SqlSessionTemplate sqlSession, User u) {

		return sqlSession.selectOne("userMapper.loginUser",u);
	}
	
	//정보수정
	public int updateUser(SqlSessionTemplate sqlSession, User u) {
		
		return sqlSession.update("userMapper.updateUser",u);
	}



}
