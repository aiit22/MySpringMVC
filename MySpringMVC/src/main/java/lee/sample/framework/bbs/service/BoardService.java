package lee.sample.framework.bbs.service;

import java.util.List;
import java.util.Map;

import lee.sample.framework.bbs.vo.Board;

public interface BoardService {
	
	public void insertBoard(Board board) throws Exception;
	
	public int updateBoard(Board board) throws Exception;
	
	public int deleteBoard(Board board) throws Exception;
	
	public Board selectBoard(Board board) throws Exception;
	
	public List<Board> selectBoardList(Map param) throws Exception;
	
	public int selectBoardCount(Map param) throws Exception;
	
	
	
}
