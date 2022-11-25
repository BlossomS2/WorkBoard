package one.onebitten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import one.onebitten.service.UserService;
import one.onebitten.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	private UserService userService;
	
	

	@PostMapping("/board_delete")
	@ResponseBody
	public String board_delete(@RequestBody BoardVo boardVo, Model model) throws Exception  {
		JsonObject jsonObject = new JsonObject();
		Gson gson = new Gson();
		
		int num =userService.board_delete(boardVo.getBoard_num());
		
		if(num == 1) {
			jsonObject.addProperty("msg", "SUCCESS");
		}else {
			jsonObject.addProperty("msg", "FAILED");
		}
		String result = gson.toJson(jsonObject);
		
		return result;
		
	}
	

	@PostMapping("/board_update")
	@ResponseBody
	public String board_update(@RequestBody BoardVo boardVo, Model model) throws Exception  {
		JsonObject jsonObject = new JsonObject();
		Gson gson = new Gson();
		int num = userService.board_update(boardVo);
		
		
		
		if(num == 1) {
			jsonObject.addProperty("msg", "SUCCESS");
		}else {
			jsonObject.addProperty("msg", "FAILED");
		}
		String result = gson.toJson(jsonObject);
		return result;
	}
	
	
	
	@PostMapping("/board_insert")
	@ResponseBody
	public String board_insert(@RequestBody BoardVo boardVo, Model model) throws Exception {
		int num = userService.board_insert(boardVo);
		
		JsonObject jsonObject = new JsonObject();
		Gson gson = new Gson();
		
		if(num == 1) {
			jsonObject.addProperty("msg", "SUCCESS");
		}else {
			jsonObject.addProperty("msg", "FAILED");
		}
		String result = gson.toJson(jsonObject);
		return result;
	}
	
	@GetMapping("/index_main")
	public String login_success(Model model) throws Exception {
		System.out.println("success login");
		
		JsonObject jsonObject = new JsonObject();
		
		model.addAttribute("boardList",userService.board_list() );
		return "index";

	}

	
	@GetMapping("/board_write")
	public String board_write() {
		return "write";
	}

	@GetMapping("/board_detail")
	public String board_detail(@RequestParam int board_num, Model model) {
		BoardVo board = userService.check_board(board_num);
		
		model.addAttribute("board",board);
		
		return "check_board";
	}
	
}
