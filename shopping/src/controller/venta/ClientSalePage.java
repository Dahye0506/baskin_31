package controller.venta;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.SalesDAO;
import model.DTO.ClientSalesDTO;

public class ClientSalePage {
	public void clientSale(HttpServletRequest request) {
		//memid받아오기
		String memId = request.getParameter("memId");
		if(memId == "") {
			memId = null;
		}
		
		SalesDAO dao = new SalesDAO();
		//여러개로 받아와야하니까 list
		List<ClientSalesDTO> dto = dao.salesList(memId);
		request.setAttribute("list", dto);
		
	}

}

