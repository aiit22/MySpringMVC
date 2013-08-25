package lee.sample.framework.bbs.service.impl;

import java.util.List;
import java.util.Map;

import lee.sample.framework.bbs.dao.BoardDao;
import lee.sample.framework.bbs.service.BoardService;
import lee.sample.framework.bbs.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="ibatisBoardService")
public class IbatisBoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	public void insertBoard(Board board){
		boardDao.insertBoard(board);
	}
	
	public int updateBoard(Board board){
		return boardDao.updateBoard(board);
	}
	
	public int deleteBoard(Board board){
		return boardDao.deleteBoard(board);
	}
	
	public Board selectBoard(Board board){
		return boardDao.selectBoard(board);
	}
	
	public List<Board> selectBoardList(Map param) {
		return boardDao.selectBoardList(param);
	}
	
	public int selectBoardCount(Map param) {
		return boardDao.selectBoardCount(param);
	}
}
