package my.mini.project.user.model.service;

import my.mini.project.user.model.vo.User;

public interface UserService {
	
	//회원가입 (insert)
	int insertUser(User u);

	//로그인
	User loginUser(User u);

}
