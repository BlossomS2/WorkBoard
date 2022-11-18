package one.onebitten.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import one.onebitten.service.UserService;
import one.onebitten.vo.BoardVo;
import one.onebitten.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	HttpSession session;
	HttpServletRequest request;
	HttpServletResponse response;

	@RequestMapping("/")
	public String index() {

		System.out.println("inside controller / ");
		return "login";

	}

	@PostMapping("/join")
	public String name(HttpServletRequest req, Model model, UserVo user) throws Exception {

		String id = req.getParameter("user_id");
		String name = req.getParameter("user_name");
		String pw = req.getParameter("user_passwd");
		user.setUser_id(id);
		user.setUser_name(name);
		user.setUser_passwd(pw);
		System.out.println("user info : " + user.toString());

		int num = userService.UserRegister(user);

		if (num == 1) {
			System.out.println("join asuccess");
			return "login";
		} else {
			System.out.println("join failed");
			return "test";
		}
	}

	@PostMapping("/join_user")
	@ResponseBody
	public String join(@RequestBody UserVo userVo, Model model) throws Exception {

		return "";
	}

	@PostMapping("/login_check")
	@ResponseBody
	public String login_check(@RequestBody UserVo user, Model model) throws Exception {
		UserVo userDto = userService.login_check(user.getUser_id());

		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();

		if (user.getUser_id().equals(userDto.getUser_id()) && user.getUser_passwd().equals(userDto.getUser_passwd())) {
			System.out.println("success login");
			String userId = userDto.getUser_id();
			System.out.println("userId : " + userId);
			try {
				session = request.getSession();
				session.setAttribute("userId", userId);
			} catch (Exception e) {
				e.printStackTrace();
			}

			jsonObject.addProperty("msg", "SUCCESS");

		} else {
			System.out.println("failed login");
			jsonObject.addProperty("msg", "FAIL");
		}
		String msgResult = gson.toJson(jsonObject);

		return msgResult;
	}

	@GetMapping("/index_main")
	public String login_success(Model model) throws Exception {
		System.out.println("success login");
		List<BoardVo> boardList = userService.board_list();
		
		model.addAttribute("boardList", boardList);
		return "index";

	}

	@GetMapping("/join")
	// @ResponseBody
	public String JoinUser() {
		System.out.println("inside controller /join");
		return "test";
	}

	@GetMapping("/login")
	public String login() {
		System.out.println("inside controller /login");
		return "login";
	}

}
