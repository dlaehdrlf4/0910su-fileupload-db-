package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import vo.Pds;

public interface PdsService {
	//데이터 삽입을 처리하기 위한 메소드 // 삽입삭제 갱신은 다줘야하기떄문에 고정시켜놓는다.
	public boolean insertPds(HttpServletRequest request);
	
	//테이블의 전체 데이터를 가져오는 메소드 // 리턴타입은 맞추면 되고 서비스의 매개변수는 거의 고정이다 
	public List<Pds> listPds(HttpServletRequest request);
}
