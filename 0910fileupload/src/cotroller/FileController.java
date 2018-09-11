package cotroller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FileUploadService;
import service.FileUploadServiceImpl;
import service.PdsService;
import service.PdsServiceImpl;
import vo.Pds;


@WebServlet("*.file")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PdsService pdsService;
	//서비스 객체를 만들어줘야한다.
	private FileUploadService fileUploadService;
    public FileController() {
        super();
        fileUploadService = FileUploadServiceImpl.shardInstance();
        pdsService = PdsServiceImpl.shardInstance();
    
    }

    //get 요청이 왔을 때 호출되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통된 요청 주소를 부분을 제외한 요청 추출하기
		//전체 요청 경로 가져오기
		String requestURI = request.getRequestURI();
		//contextPath : 서버 경로
		String contextPath = request.getContextPath();
		//requstURI 에서 contextPath와 / 제거하기
		String command = requestURI.substring(contextPath.length()+1);
		
		//세션 객체를 가져오기
		HttpSession session = request.getSession();
		
		RequestDispatcher dispatcher = null;
		
		//URL에 따른 분기문 만들기 (분기가 많을 때는 switch를 쓰는게 좋다)
		switch(command) {
		case "fileupload.file":
				//단순 페이지 이동이나 서버에서 데이터를 조회한 후 출력할 때는 포워딩을 주로 이용한다.
				dispatcher = request.getRequestDispatcher("views/fileupload.jsp");
				dispatcher.forward(request, response);
			break;
		case "upload.file":
		//	System.out.println("dfgdfg");
			//요청 처리를 위한 메소드 호출
			Map<String, Object> map = fileUploadService.fileUpload(request);
			//처리 결과를 저장
			//request.setAttribute("map", map);
			//처리결과를 출력할 페이지로 이동
			//dispatcher = request.getRequestDispatcher("views/result.jsp");
			//dispatcher.forward(request, response);
			// 작업을 수행한 경우는 리다이렉트
			session.setAttribute("map", map);
			//리다이렉트를 할 때는 결과페이지 경로를 적는 것이 아니고
			//url을 설정해서 url을 처리하는 부분에서 포워딩 시킵니다.
			response.sendRedirect("uploadresult.file");
			//작업을 했을 떄는 리다이렉트 조회하는 것은 포워드로 한다.
			//포워딩으로 했으면 새로고침을 하면 계속 만들어진다 하지만 리다이렉트로 하면 새로고침을 하면 안만들어진다.
			break;
		case "uploadresult.file":
			dispatcher = request.getRequestDispatcher("views/result.jsp");
			dispatcher.forward(request, response);
		break;
		case "input.file":
			dispatcher = request.getRequestDispatcher("views/input.jsp");
			dispatcher.forward(request, response);
			break;
		case "insert.file":
			boolean result = pdsService.insertPds(request);
			if(result == true) {
				//메인 페이지로 리다이렉트 //현재 디렉토리로 가는게 ./  이건 뒤에파일만 없어짐
					response.sendRedirect("./"); // /가 시작 페이지 위에 디렉토리가 없으니까 그냥 슬레시
			}else {
				// 실패한 경우는 데이터 삽입 페이지로 이동
				response.sendRedirect("input.file");
			}
			break;
		case "list.file":
			List<Pds> list = pdsService.listPds(request);
			
			request.setAttribute("list", list);
			
			dispatcher = request.getRequestDispatcher("/views/list.jsp");
			dispatcher.forward(request, response);
			
			break;
		}
	}

	//post 요청이 왔을 때 호출되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 요청이 왔을 때 doGet을 호출
		//한 곳에서 모든 요청을 처리하기 위해서
		doGet(request, response);
	}

}
