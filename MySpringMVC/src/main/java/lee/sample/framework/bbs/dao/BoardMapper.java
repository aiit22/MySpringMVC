package lee.sample.framework.bbs.dao;

import java.util.List;
import java.util.Map;

import lee.sample.framework.bbs.vo.Board;

public interface BoardMapper {
	public void insertBoard(Board board);
	
	public void updateBoard(Board board);
	
	public void deleteBoard(Board board);
	
	public Board selectBoard(Board board);
	
	public List<Board> selectBoardList(Map param);
	
	public int selectBoardCount(Map param);
}
