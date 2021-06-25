package controller.goods;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DAO.LoginDAO;
import model.DAO.MemberDAO;
import model.DTO.AuthInfo;
import model.DTO.ProductDTO;

public class GoodsListPage {
	public void goodsList(HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		List<ProductDTO> list = dao.goodsList();
		request.setAttribute("lists", list);
		
		//쿠키 받아오기:사용자한테서 쿠키 받아오기
		Cookie [] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				System.out.println("bvfgjsbgvfu");
				if(cookie.getName().startsWith("id")) {
					//startsWith면 첫글자만 비교
					//.equals("idStroe")
					request.setAttribute("isId", cookie.getValue());//쿠키가 가지고있는 값 전달
				}
				if(cookie.getName().startsWith("au")) {
					HttpSession session = request.getSession();
					LoginDAO ldao = new LoginDAO();
					String userId = cookie.getValue();//아래 userId값 전달
					AuthInfo authInfo = ldao.login(userId);
					session.setAttribute("authInfo", authInfo);
					
				}
			}
		}
		
	}
}
