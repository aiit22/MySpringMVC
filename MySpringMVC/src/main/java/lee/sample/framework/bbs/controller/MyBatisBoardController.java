
package lee.sample.framework.bbs.controller;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import lee.sample.framework.bbs.service.impl.MyBatisBoardService;
import lee.sample.framework.bbs.vo.Board;
import lee.sample.framework.util.pagination.PaginationInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyBatisBoardController {
private static final Logger logger = LoggerFactory.getLogger(MyBatisBoardController.class);
	
	@Resource(name="myBatisBoardService")
	MyBatisBoardService myBatisBoardService;
	
	
	/**
	@RequestMapping(value="boardDatail.do",method=RequestMethod.GET)
	public String getBoardNormal(@RequestParam(value="id") int id,Locale locale, Model model) throws Exception {
		logger.info("MyBatisBoardController !!!!!!!");
		
		Board board = new Board();
		board.setBbsId(id);
		board = myBatisBoardService.selectBoard(board);
		
		model.addAttribute("board",board);
		return "boardDetail";

	}
	
	@RequestMapping(value="boardList.do",method=RequestMethod.GET)
	public String getBoardListNormal(@RequestParam(value = "page", required =false) String pageNo, 
			@RequestParam(value = "rows", required =false) String rowsNo, 
			ModelMap model, Map<String, Object> commandMap) throws Exception {
		
		int currentPageNo;
        try {
            currentPageNo = Integer.parseInt(pageNo);
        } catch (Exception e) {
            currentPageNo = 1;
        }
        
        int CurrentrowsNo;
        try {
        	CurrentrowsNo = Integer.parseInt(rowsNo);
        } catch (Exception e) {
        	CurrentrowsNo = 10;
        }

        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(currentPageNo);
        paginationInfo.setRecordCountPerPage(CurrentrowsNo);
        paginationInfo.setPageSize(10);
        
        commandMap.put("firstIndex", paginationInfo.getFirstRecordIndex());
        commandMap.put("lastIndex", paginationInfo.getLastRecordIndex());
        commandMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage());
		
        List<Board> boardlist = myBatisBoardService.selectBoardList(commandMap);
		model.addAttribute("boardlist",boardlist);
		
		int boardCount = myBatisBoardService.selectBoardCount(commandMap);
        paginationInfo.setTotalRecordCount(boardCount);
        model.addAttribute("paginationInfo", paginationInfo);

	        
		return "boardList";

	}
	
	
	@RequestMapping(value="/mybatis/boardDatail.do",method=RequestMethod.GET)
	public String getBoard(@RequestParam(value="id") int id,Locale locale, Model model) throws Exception {
		logger.info("MyBatisBoardController !!!!!!!");
		
		Board board = new Board();
		board.setBbsId(id);
		board = myBatisBoardService.selectBoard(board);
		
		model.addAttribute("board",board);
		return "boardDetail";

	}
	
	@RequestMapping(value="/mybatis/boardList.do",method=RequestMethod.GET)
	public String getBoardList(@RequestParam(value = "page", required =false) String pageNo, 
			@RequestParam(value = "rows", required =false) String rowsNo, 
			ModelMap model, Map<String, Object> commandMap) throws Exception {
		
		int currentPageNo;
        try {
            currentPageNo = Integer.parseInt(pageNo);
        } catch (Exception e) {
            currentPageNo = 1;
        }
        
        int CurrentrowsNo;
        try {
        	CurrentrowsNo = Integer.parseInt(rowsNo);
        } catch (Exception e) {
        	CurrentrowsNo = 10;
        }

        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(currentPageNo);
        paginationInfo.setRecordCountPerPage(CurrentrowsNo);
        paginationInfo.setPageSize(10);
        
        commandMap.put("firstIndex", paginationInfo.getFirstRecordIndex());
        commandMap.put("lastIndex", paginationInfo.getLastRecordIndex());
        commandMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage());
		
        List<Board> boardlist = myBatisBoardService.selectBoardList(commandMap);
		model.addAttribute("boardlist",boardlist);
		
		int boardCount = myBatisBoardService.selectBoardCount(commandMap);
        paginationInfo.setTotalRecordCount(boardCount);
        model.addAttribute("paginationInfo", paginationInfo);

	        
		return "boardList";

	}
	**/
	
	
	@RequestMapping(value="/mybatis/jqgrid.do",method=RequestMethod.GET)
	public String goGrid() {
		
			        
		return "mybatis_jqgridboardList";

	}
	
	
	@RequestMapping(value="/mybatis/boardListJson.do",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBoardListJson(@RequestParam(value = "page", required =false) String pageNo,
			@RequestParam(value = "rows", required =false) String rowsNo,
			ModelMap model, Map<String, Object> commandMap) throws Exception {
		
		int currentPageNo;
        try {
            currentPageNo = Integer.parseInt(pageNo);
        } catch (Exception e) {
            currentPageNo = 1;
        }

        int CurrentrowsNo;
        try {
        	CurrentrowsNo = Integer.parseInt(rowsNo);
        } catch (Exception e) {
        	CurrentrowsNo = 10;
        }
        
        
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(currentPageNo);
        paginationInfo.setRecordCountPerPage(CurrentrowsNo);
        paginationInfo.setPageSize(10);
        
        commandMap.put("firstIndex", paginationInfo.getFirstRecordIndex());
        commandMap.put("lastIndex", paginationInfo.getLastRecordIndex());
        commandMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage());
		
        List<Board> boardlist = myBatisBoardService.selectBoardList(commandMap);
        int boardCount = myBatisBoardService.selectBoardCount(commandMap);
        paginationInfo.setTotalRecordCount(boardCount);
        
        
        
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        resultMap.put("total", paginationInfo.getTotalPageCount());
        resultMap.put("page", currentPageNo);
        resultMap.put("records", boardCount);
        resultMap.put("rows", boardlist);
		return resultMap;

	}
	
	@RequestMapping(value="/mybatis/bbsAdd.do",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addBbs(@ModelAttribute Board board, BindingResult bindingResult, Model model) {
		
        boolean bsuccess = true;
        List<String> message = new ArrayList<String>();
        try {
        	myBatisBoardService.insertBoard(board);
        	
        } catch (Exception e) {
        	bsuccess= false;
        	message.add("Insert Fail!!");
        	
        }
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        resultMap.put("success", bsuccess);
        resultMap.put("message", message);
        
        return resultMap;

	}
	
	@RequestMapping(value="/mybatis/bbsUpdate.do",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateBbs(@ModelAttribute Board board, BindingResult bindingResult, Model model) {
		
        boolean bsuccess = true;
        List<String> message = new ArrayList<String>();
        logger.debug("##################################");
        logger.debug("#########" + board.toString());
        try {
        	myBatisBoardService.updateBoard(board);
        	
        } catch (Exception e) {
        	bsuccess= false;
        	message.add("Update Fail!!");
        	
        }
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        resultMap.put("success", bsuccess);
        resultMap.put("message", message);
        
        return resultMap;

	}
	
	@RequestMapping(value="/mybatis/bbsDelete.do",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteBbs(@ModelAttribute Board board, BindingResult bindingResult, Model model) {
		
        boolean bsuccess = true;
        List<String> message = new ArrayList<String>();
        try {
        	myBatisBoardService.deleteBoard(board);
        	
        } catch (Exception e) {
        	bsuccess= false;
        	message.add("delete Fail!!");
        	
        }
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        resultMap.put("success", bsuccess);
        resultMap.put("message", message);
        
        return resultMap;

	}

	
}
