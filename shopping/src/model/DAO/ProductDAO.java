package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.ProductTotalDTO;

public class ProductDAO extends DataBaseInfo {
	public List<ProductTotalDTO> productTotPage(){
		List<ProductTotalDTO> list = new ArrayList<ProductTotalDTO>();
		sql = "select prod.prod_num, PROD.PROD_NAME, PROD.PROD_PRICE, SUM(prod.prod_price) "
			+ "FROM PRODUCTS PROD, PURCHASE_LIST PUL "
			+ "WHERE PROD.PROD_NUM = PUL.PROD_NUM "
			+ "GROUP BY prod.prod_num, PROD.PROD_NAME, PROD.PROD_PRICE "
			+ "ORDER BY SUM(prod.prod_price) desc";
		
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProductTotalDTO dto = new ProductTotalDTO();
				dto.setProdNum(rs.getString(1));
				dto.setProdName(rs.getString(2));
				dto.setProdPrice(rs.getString(3));
				dto.setSumPrice(rs.getString(4));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
	}
}
