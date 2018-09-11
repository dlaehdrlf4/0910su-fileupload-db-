package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface EtcService {
	//메일 보내기를 처리할 메소드
	public boolean mailSend(HttpServletRequest request);
	
	//웹에서 문자열을 읽어서 리턴하는 메소드
	public String proxy(HttpServletRequest request);

	//5초 마다 푸시를 보내는 메소드
	public void push(HttpServletRequest request, HttpServletResponse response);

}
