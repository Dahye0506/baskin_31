package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.CartDTO;

public class GoodsCartQtyDownPage {
	public void cartQtyDown(HttpServletRequest request) {
		String prodNum = request.getParameter("prodNum");
		String pordPrice = request.getParameter("prodPrice");
		//2
		HttpSession session = request.getSession();//정의
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");//가져오기
		//3
		String memId = authInfo.getUserId();
		//5
		CartDTO dto = new CartDTO();
		dto.setMemId(memId);
		dto.setCartQty("1");
		dto.setCartPrice(Integer.parseInt(pordPrice));
		dto.setProdNum(prodNum);
		//4
		GoodsDAO dao = new GoodsDAO();
		dao.cartQtyDown(dto);
		
	}
}
