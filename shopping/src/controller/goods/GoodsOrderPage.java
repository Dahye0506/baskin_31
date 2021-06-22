package controller.goods;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.PurchaseDTO;

public class GoodsOrderPage {
	public String goodsOrder(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();//유져아이디 가져오기
		//
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String purchaseDate = df.format(day);
		String purchaseNum = df.format(day);
		
		PurchaseDTO dto = new PurchaseDTO();
		dto.setPurchaseNum(purchaseNum);
		dto.setPurchaseDate(purchaseDate);
		dto.setPurchaseTotPrice(request.getParameter("purchaseTotPrice"));
		dto.setMemId(memId);
		dto.setPurchaseAddr(request.getParameter("purchaseAddr"));

		dto.setPurchaseMethod(request.getParameter("purchaseMethod"));
		dto.setPurchaseRequest(request.getParameter("purchaseRequest"));
		dto.setReceiverName(request.getParameter("purchaseName"));
		dto.setReceiverPhone(request.getParameter("purchasePhone"));
		
		GoodsDAO dao = new GoodsDAO();
		dao.purchaseInsert(dto);
		String [] prodNums = request.getParameter("prodNums").split(",");
		
		for(String prodNum : prodNums) {
			dao.purchaseListInsert(purchaseNum, prodNum, memId);		
		}
		for(String prodNum : prodNums) {
			dao.cartDel(prodNum, memId);	
		}
		return purchaseNum + "," + dto.getPurchaseTotPrice();
		
	}
	
	
}
