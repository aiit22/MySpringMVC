package lee.sample.framework.bbs.service.impl;

import javax.annotation.Resource;

import lee.sample.framework.bbs.vo.Board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring-test, junit이 설치되어 있어야 함
 *
 */
@ContextConfiguration(locations={"classpath:/spring/spring-mybatis.xml"})
@RunWith(value=SpringJUnit4ClassRunner.class)
public class MyBatisBoardServiceTest {
	
	
//	@Resource(name="myBatisBoardService")
//	MyBatisBoardService myBatisBoardService;
//	
//	@Test
//	public void selectBoard(){
//		Board board = new Board();
//		board.setBbsId(1);
//		
//		Board board1 = new Board();
//		board1 = myBatisBoardService.selectBoard(board);
//		System.out.println("title : " + board1.getBbsTitle());
//	}
//	
//	@Test
//	public void insertBoard() {
//		Board board = new Board();
//		board.setBbsId(2);
//		board.setBbsTitle("test2");
//		board.setBbsContent("한글은 잘될까?");
//		board.setBbsFile("test.xml");
//		myBatisBoardService.insertBoard(board);
//		
//		
//	}
}
