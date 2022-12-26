package my.mini.project.user.model.service;

import my.mini.project.user.model.vo.User;

public interface UserService {
	
	//회원가입 (insert)
	int insertUser(User u);

	//로그인
	User loginUser(User u);
	
	//정보수정
	int updateUser(User u);
	
	//회원탈퇴
	int deleteUser(String userId);

}
