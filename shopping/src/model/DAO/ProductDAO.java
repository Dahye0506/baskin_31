package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.ProductTotalDTO;

public class ProductDAO extends DataBaseInfo {
	public List<ProductTotalDTO> productTotPage(){
		List<ProductTotalDTO> list = new ArrayList<ProductTotalDTO>();
		sql = "select prod.prod_num, PROD.PROD_NAME, PROD.PROD_PRICE, SUM(prod_price), COUNT(*) "
			+ "    FROM products prod, purchase_list pul "
			+ "    WHERE prod.prod_num = pul.prod_num "
			+ "	GROUP BY prod.prod_num, PROD.PROD_NAME, PROD.PROD_PRICE " ;

		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProductTotalDTO dto = new ProductTotalDTO();
				dto.setProdNum(rs.getString(1));
				dto.setProdName(rs.getString(2));
				dto.setProdPrice(rs.getString(3));
				dto.setProdSumPrice(rs.getString(4));
				dto.setCount(rs.getString(5));
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
