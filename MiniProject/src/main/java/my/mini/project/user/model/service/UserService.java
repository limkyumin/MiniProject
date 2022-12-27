package my.mini.project.user.model.service;

import my.mini.project.user.model.vo.User;

public interface UserService {
	
	//회원가입
	int insertUser(User u);
	
	//아이디 중복체크
	int idCheck(String checkId);

	//로그인
	User loginUser(User u);
	
	//정보수정
	int updateUser(User u);
	
	//회원탈퇴
	int deleteUser(String userId);


}
