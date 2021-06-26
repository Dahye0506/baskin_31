package controller.venta;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ProductDAO;
import model.DTO.CustomerTotalDTO;
import model.DTO.ProductTotalDTO;

public class ProductTotalPage {
	public void productTotPage(HttpServletRequest request) {
		//sql문 받아올곳
		ProductDAO dao = new ProductDAO();
		List<ProductTotalDTO> list = dao.productTotPage(); 
		String googleList = "[['상품번호', '상품이름', '상품금액','총금액']";
		for(ProductTotalDTO dto : list) {
			googleList += ",['" + dto.getProdNum() + "',"
					   + "'"+ dto.getProdName() + "'," 
					   + dto.getProdPrice() + "," + dto.getSumPrice()
					   +  "]";
		}
		googleList+="]";// 맨앞에[ 열어준거 닫기
		request.setAttribute("googleList", googleList);
		request.setAttribute("list", list);
		
	}

}
