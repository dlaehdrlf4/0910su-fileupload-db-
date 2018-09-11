package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//웹 소켓 서버 클래스
@ServerEndpoint("/websocket")
public class WebSoketService {
	//접속한 클라이언트들의 목록을 저장할 인스턴스
	static List<Session> list = new ArrayList<Session>();
	
	
	// 클라이언트가 연결 되었을 때 호출되는 메소드
	@OnOpen
	public void onOpen(Session session) {
		list.add(session);
	}
	
	//클라이언트가 연결 해제되었을 때 호출되는 메소드
	@OnClose
	public void onClose(Session session) {
		list.remove(session);
	}
	
	
	//클라이언트의 메시지가 왔을 때 호출되는 메소드
	@OnMessage
	public void onMessage(String message, Session session) 
		throws IOException, InterruptedException{
		//받은 메시지를 모든 클라이언트에게 전송
			for(Session s : list) {
				s.getBasicRemote().sendText(message);
			}
		}
	}
	
