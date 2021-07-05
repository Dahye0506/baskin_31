package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.MemberDTO;

public class MemberRepository {//컨텍스트에등록
	@Autowired
	SqlSession sqlsession;
	
	String namespace ="mapper.memberMapper"; //네임스페이스이름과 마이바티스 매퍼이름은 같지않아도 됨
	String statement; //
	
	public List<MemberDTO> memList(String memId){
		statement =  namespace +".memList";
		return sqlsession.selectList(statement,memId);
		
	}

	//반환형 없으면 void //반환형 있으면 String
	public void memJoin(MemberDTO dto) {
		statement = namespace + ".memJoin";
		sqlsession.insert(statement, dto);
	}
	
	//수정
	public void memUpdate(MemberDTO dto){
		statement = namespace + ".memUpdate";
		sqlsession.insert(statement, dto);
	}
	
	//회원 삭제
	public void memDel(String memId) {
		statement = namespace + ".memDel";
		
		int i = sqlsession.delete(statement, memId);
		System.out.println(i+"행이 삭제되었습니다.");
	}

	
	

	
}
