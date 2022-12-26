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
	
	//로그인
	@Override
	public User loginUser(User u) {
		
		User loginUser = userDao.loginUser(sqlSession,u);
		
		return loginUser;
	}
	
	//정보수정
	@Override
	public int updateUser(User u) {
		
		int loginUser = userDao.updateUser(sqlSession, u);
		
		return 0;
	}
	
	//회원탈퇴
	@Override
	public int deleteUser(String userId) {
		
		int result = userDao.deleteUser(sqlSession,userId);
		
		return result;
	}

}
