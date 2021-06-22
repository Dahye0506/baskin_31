package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.CartDTO;

public class GoodsCartProdDel {
	public void cartProdDel(HttpServletRequest request) {
		//1받아오기 세션
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)request.getAttribute("authInfo");
		
		String memId = authInfo.getUserId();
		String ProdNum = request.getParameter("prodNum");
		CartDTO dto = new CartDTO();
		dto.setProdNum(ProdNum);
		dto.setMemId(memId);
		GoodsDAO dao = new GoodsDAO();
		dao.cartProdDel(dto);
		
		
	}

}
