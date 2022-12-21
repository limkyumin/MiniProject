package my.mini.project.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import my.mini.project.user.model.vo.User;

@Repository
public class UserDao {

	public int insertUser(SqlSessionTemplate sqlSession, User u) {
		
		return sqlSession.insert("userMapper.insertUser",u);
	}

}
