package controller.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import model.DAO.LoginDAO;
import model.DTO.AuthInfo;

public class LoginPage {
	public void login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		LoginDAO dao = new LoginDAO();
		AuthInfo authInfo = dao.login(userId);
		if(authInfo == null) {
			session.removeAttribute("pwFail");
			session.setAttribute("userFail", "아이디가 존재하지 않습니다.");
		}else {
			session.removeAttribute("userFail");
			if(userPw.equals(authInfo.getUserPw())) {
				session.removeAttribute("pwFail");
				/// 웹브라우저를 닫기 전까지 사용할 수 있도록 session에 저장
				session.setAttribute("authInfo", authInfo);
				
				//자동 로그인체크 박스, 값받았는지 확인
				String autologin = request.getParameter("autologin");
				if(autologin != null && autologin.equals("auto")) {
					Cookie cookie = new Cookie("autoLogin",userId);
											// 여기 이름이 중요
					cookie.setPath("/");
					cookie.setMaxAge(0); //60초,60분,24시간,30일
					response.addCookie(cookie);//유저 컴퓨터 웹브러우저에 쿠키 전달
					
				}
				
				//로그인될때 id쿠키를 만들어줌
				String idStore=request.getParameter("idStore");
				
				if(idStore != null && idStore.equals("store")) {
					System.out.println("쿠키 생성");
					//로그인이 되었다면 쿠키 생성
					Cookie cookie = new Cookie("idStore",userId);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30); //60초,60분,24시간,30일
					response.addCookie(cookie);//유저 컴퓨터 웹브러우저에 쿠키 전달
				}else {
					//아이디 저장에 체크박스 풀면 쿠키 삭제
					Cookie cookie = new Cookie("idStore",userId);
					cookie.setPath("/");
					cookie.setMaxAge(0); //60초,60분,24시간,30일
					response.addCookie(cookie);//유저 컴퓨터 웹브러우저에 쿠키 전달
				}
				
			}else {
				session.setAttribute("pwFail", "비밀번호가 틀렸습니다.");
			}
		}
	}
}