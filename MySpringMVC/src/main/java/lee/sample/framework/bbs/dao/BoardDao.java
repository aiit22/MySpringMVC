package lee.sample.framework.bbs.dao;

import java.util.List;
import java.util.Map;

import lee.sample.framework.bbs.vo.Board;
import lee.sample.framework.util.dataaccess.IbatisAbstractDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDao extends IbatisAbstractDAO {
	
	public void insertBoard(Board board) throws DataAccessException{
		insert("insertBoard", board);
	}
	
	public int updateBoard(Board board) {
		return update("updateBoard", board);
	}
	
	public int deleteBoard(Board board) {
		return delete("deleteBoard",board);
	}
	
	public Board selectBoard(Board board) {
		return (Board) selectByPk("selectBoard",board);
	}
	
	@SuppressWarnings("unchecked")
	public List<Board> selectBoardList(Map param) {
		return list("selectBoardList",param);
	}
	
	public int selectBoardCount(Map param) {
		return (Integer) selectByPk("selectBoardCount",param);
	}
}
