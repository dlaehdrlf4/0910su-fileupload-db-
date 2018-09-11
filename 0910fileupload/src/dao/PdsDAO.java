package dao;

import java.util.List;

import vo.Pds;

public interface PdsDAO {
	// Pds 테이블에서 가장 큰 code를 찾아오는 메소드
	public int  maxCode();
	
	//Pds 테이블에 데이터를 삽입하는 메소드
	public boolean insertPds(Pds pds);
	
	//Pds 테이블의 전체 데이터를 가져오는 메소드 // 전체 데이터를 가져올 때는 파라미터가 없다.
	public List<Pds> listPds();
	
}
