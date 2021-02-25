package kr.daoko.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Choi-JinHwan
 */
@Controller
public class IndexController {

	@GetMapping
	public String index(){
		return "redirect:/post/list";
	}

}
