package controller.goods;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DTO.AuthInfo;
import model.DTO.ProductReviewDTO;


public class GoodsReviewPage {
	public void review(HttpServletRequest request) {
		
		//리뷰 저장파일
		String path = "goods/review";
		String realPath = request.getServletContext().getRealPath(path);
		int size = 1024*1024*5; //5메가
		try {
		MultipartRequest multi = null;
		multi = new MultipartRequest(request,realPath,size,"utf-8",new DefaultFileRenamePolicy());
		//
		ProductReviewDTO dto = new ProductReviewDTO();
		dto.setProdNum(request.getParameter("prodNum"));
		dto.setPurchaseNum(request.getParameter("purchaseNum"));
		dto.setReviewContent(multi.getParameter("reviewContent"));
		
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
