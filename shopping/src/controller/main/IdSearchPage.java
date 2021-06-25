package controller.main;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class IdSearchPage {
	public void idFind(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MemberDTO dto = new MemberDTO();
		dto.setMemAddress(request.getParameter("memAddress"));
		dto.setMemEmail(request.getParameter("memEmail"));
		dto.setMemPhone(request.getParameter("memPhone"));
		MemberDAO dao = new MemberDAO();
		dao.idFind(dto);
		
		//MemberDAO에서 받아옴
		if(dto.getMemId()==null) {
			request.setAttribute("idFail", "정보가일치하지 않습니다.");
		}else {
			request.setAttribute("dto", dto);
		}
		
	}

}
