package controller.venta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VentaController extends HttpServlet 
implements Servlet{
public void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String requestURI = request.getRequestURI(); //주소를 알기 위해서는 request.URI가 있어야함
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());// URI를 contextPath의 길이만큼 잘라낸다.
//      ////      ////      ////      ////      ////      ////      ////      ////      ////      ////      //
		if(command.equals("/venta.vnt")) {
			ClientSalePage action = new ClientSalePage();
			action.clientSale(request);
						
			RequestDispatcher dispatcher = request.getRequestDispatcher("sales/venta.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/userSales.vnt")) {//고객별 주문상태
			UserSalesPage action = new UserSalesPage();
			action.userSales(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("sales/userSales.jsp");//세일즈페이지가져오기
			dispatcher.forward(request, response);
		}else if(command.equals("/customerTotal.vnt")) {//메인-판매현황 클릭
			CustomerTotalPage action = new CustomerTotalPage();
			action.customerTotal(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("sales/customerTotal.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/createDelivery.vnt")) {
			//db
			CreateDeliveryPage action = new CreateDeliveryPage();
			action.execute(request);
			//배송관련
			RequestDispatcher dispatcher = request.getRequestDispatcher("sales/deliveryForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/deliveryOk.vnt")) {
			DeliveryOkPage action = new DeliveryOkPage();
			action.execute(request);
			response.sendRedirect("venta.vnt");
		}
		///상품별 판매 현황
		else if(command.equals("/productTypeTotal.vnt")) {
			ProductTotalPage action = new ProductTotalPage();
			action.productTotPage(request);
			
			//상품별 판매현황으로 이동
			RequestDispatcher dispatcher = request.getRequestDispatcher("sales/productTypeTotal.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
