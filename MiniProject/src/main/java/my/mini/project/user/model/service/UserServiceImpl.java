package my.mini.project.user.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.mini.project.user.model.dao.UserDao;
import my.mini.project.user.model.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//회원가입(insert)
	@Override
	public int insertUser(User u) {
		
		int result = userDao.insertUser(sqlSession,u);
		
		return result;
	}

}
