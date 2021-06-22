package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.PaymentDTO;

public class PaymentPage {
	
	public void payment(HttpServletRequest request) {
		//2
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		//1. dto 생성
		String memId = authInfo.getUserId();
		PaymentDTO dto = new PaymentDTO();
		//3
		dto.setMemId(memId);
		dto.setPaymentApprPrice(request.getParameter("paymentApprPrice"));
		dto.setPaymentMethod("카드");
		dto.setPayMentNumber(request.getParameter("paymentNumber"));
		dto.setPurchaseNum(request.getParameter("purchaseNum"));

		//4 다오
		GoodsDAO dao = new GoodsDAO();
		dao.payment(dto);
		//5
		request.setAttribute("money", dto.getPaymentApprPrice());
		
	}
	

}
