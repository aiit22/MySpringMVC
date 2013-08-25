package lee.sample.framework.bbs.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import lee.sample.framework.bbs.service.BoardService;
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
public class IbatisBoardController {
private static final Logger logger = LoggerFactory.getLogger(IbatisBoardController.class);
	
	@Resource(name="ibatisBoardService")
	BoardService iBatisBoardService;
	
	@RequestMapping(value="home.do",method=RequestMethod.GET)
	public String goHome() throws Exception {
		
		return "home";

	}
	
	@RequestMapping(value="left.do",method=RequestMethod.GET)
	public String goLeft() throws Exception {
		
		return "left";

	}
	
	@RequestMapping(value="boardDatail.do",method=RequestMethod.GET)
	public String getBoardNormal(@RequestParam(value="id") int id,Locale locale, Model model) throws Exception {
		
		
		Board board = new Board();
		board.setBbsId(id);
		board = iBatisBoardService.selectBoard(board);
		
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
		
        List<Board> boardlist = iBatisBoardService.selectBoardList(commandMap);
		model.addAttribute("boardlist",boardlist);
		
		int boardCount = iBatisBoardService.selectBoardCount(commandMap);
        paginationInfo.setTotalRecordCount(boardCount);
        model.addAttribute("paginationInfo", paginationInfo);

	        
		return "boardList";

	}
	
	@RequestMapping(value="/ibatis/boardDatail.do",method=RequestMethod.GET)
	public String getBoard(@RequestParam(value="id") int id,Locale locale, Model model) throws Exception {
		logger.info("MyBatisBoardController !!!!!!!");
		
		Board board = new Board();
		board.setBbsId(id);
		board = iBatisBoardService.selectBoard(board);
		
		model.addAttribute("board",board);
		return "boardDetail";

	}
	
	@RequestMapping(value="/ibatis/boardList.do",method=RequestMethod.GET)
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
		
        List<Board> boardlist = iBatisBoardService.selectBoardList(commandMap);
		model.addAttribute("boardlist",boardlist);
		
		int boardCount = iBatisBoardService.selectBoardCount(commandMap);
        paginationInfo.setTotalRecordCount(boardCount);
        model.addAttribute("paginationInfo", paginationInfo);

	        
		return "boardList";

	}
	
	@RequestMapping(value="/ibatis/jqgrid.do",method=RequestMethod.GET)
	public String goGrid() {
		return "ibatis_jqgridboardList";
	}
	
	
	@RequestMapping(value="/ibatis/boardListJson.do",method=RequestMethod.GET)
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
		
        List<Board> boardlist = iBatisBoardService.selectBoardList(commandMap);
        int boardCount = iBatisBoardService.selectBoardCount(commandMap);
        paginationInfo.setTotalRecordCount(boardCount);
        
        
        
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        resultMap.put("total", paginationInfo.getTotalPageCount());
        resultMap.put("page", currentPageNo);
        resultMap.put("records", boardCount);
        resultMap.put("rows", boardlist);
        return resultMap;

	}
	
	@RequestMapping(value="/ibatis/bbsAdd.do",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addBbs(@ModelAttribute Board board, BindingResult bindingResult, Model model) {
		
        boolean bsuccess = true;
        List<String> message = new ArrayList<String>();
        try {
        	iBatisBoardService.insertBoard(board);
        	
        } catch (Exception e) {
        	bsuccess= false;
        	message.add("Insert Fail!!");
        	
        }
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        resultMap.put("success", bsuccess);
        resultMap.put("message", message);
        
        return resultMap;
	}
	
}