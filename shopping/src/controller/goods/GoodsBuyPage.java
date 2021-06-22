package controller.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.ProductCartDTO;

public class GoodsBuyPage {
	public void goodsBuy(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		String memId = authInfo.getUserId();
		
		String [] ProdNums = request.getParameterValues("prodCk");
		List<ProductCartDTO> list = new ArrayList<ProductCartDTO>();
		GoodsDAO dao = new GoodsDAO();
		//for문
		for(String ProdNum : ProdNums) {
			ProductCartDTO dto = dao.prodCart(ProdNum, memId);
					//dto 받아오기 dao로부터
			list.add(dto);
		}
		request.setAttribute("list", list);
	}

}
