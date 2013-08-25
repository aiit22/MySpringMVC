package lee.sample.framework.bbs.service.impl;

import java.util.List;
import java.util.Map;

import lee.sample.framework.bbs.dao.BoardMapper;
import lee.sample.framework.bbs.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="myBatisBoardService")
public class MyBatisBoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	public void insertBoard(Board board){
		boardMapper.insertBoard(board);
	}
	
	public void updateBoard(Board board){
		boardMapper.updateBoard(board);
	}
	
	public void deleteBoard(Board board){
		boardMapper.deleteBoard(board);
	}
	
	public Board selectBoard(Board board){
		return boardMapper.selectBoard(board);
	}
	
	public List<Board> selectBoardList(Map param) {
		return boardMapper.selectBoardList(param);
	}
	
	public int selectBoardCount(Map param) {
		return boardMapper.selectBoardCount(param);
	}
}
