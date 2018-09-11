package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EtcService;
import service.EtcServiceImpl;

/**
 * Servlet implementation class EtcController
 */
public class EtcController extends HttpServlet {
	private EtcService etcService;

	public EtcController() {
		super();
		etcService = EtcServiceImpl.shardInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);

		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();

		System.out.println(command);
		switch (command) {
		case "mailsend.do":
			dispatcher = request.getRequestDispatcher("/views/emailsend.jsp");
			dispatcher.forward(request, response);
			break;
		case "sendmail.do":
			boolean r = etcService.mailSend(request);
			System.out.println(r);
			break;
		case "proxy.do":
			String xml = etcService.proxy(request);

			System.out.println(xml);
			// 결과를 출력하기 위해서 저장
			request.setAttribute("xml", xml);
			// 결과 페이지로 이동
			dispatcher = request.getRequestDispatcher("views/proxy.jsp");
			dispatcher.forward(request, response);
			break;
		case  "push.do":
			etcService.push(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
