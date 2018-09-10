package service;

import javax.servlet.http.HttpServletRequest;

public interface PdsService {
	//데이터 삽입을 처리하기 위한 메소드 // 삽입삭제 갱신은 다줘야하기떄문에 고정시켜놓는다.
	public boolean insertPds(HttpServletRequest request);
	
	
}
