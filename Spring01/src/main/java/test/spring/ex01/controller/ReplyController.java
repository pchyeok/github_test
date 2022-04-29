package test.spring.ex01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReplyController {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyController.class);
	
	@GetMapping("/reply")
	public void replyGET() {
	logger.info("replyController replyGET() 호출" )	;
	}; //end replyGET()
}// end ReplyController
