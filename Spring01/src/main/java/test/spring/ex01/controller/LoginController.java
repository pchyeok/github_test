package test.spring.ex01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/member")
public class LoginController {
	private static final Logger logger = 
			LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/login")
	public void loginGET() {
		logger.info("loginGET ȣ��" );
	}//end loginGET
	
	
	@PostMapping("/login")
	public String loginPOST(String boardId, String password, HttpServletRequest request) {
		logger.info("loginPOST 호출");
		
		if(boardId.equals("test") && password.equals("1234")) {
			logger.info("test계정 로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("boardId", boardId);
			
			String targetURL = (String) session.getAttribute("targetURL");
			logger.info("해당 url 경로 : " + targetURL);
			if(targetURL != null) {
				//경로가 null이 아니면
				session.removeAttribute("targetURL");
				return "redirect:" + targetURL;
			} else {
				return "redirect:/board/list";
				// 없으면 메인 페이지로 경로 변경
			}
		} else {
			logger.info("테스트계정 로그인 실패");
			return "redirect:/member/login";
			// 로그인화면으로 되돌리기
		}
	}// end loginPOST
	
	@GetMapping("/logout")
	public String logoutGET(HttpServletRequest request) {
		logger.info("logoutGET() 호출");
		
		HttpSession session = request.getSession();
		session.removeAttribute("boardId");
		
		return "redirect:/board/list";
	}// end logoutGET
}// end LoginController
