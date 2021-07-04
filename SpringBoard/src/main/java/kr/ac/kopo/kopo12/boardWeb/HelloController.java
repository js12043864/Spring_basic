package kr.ac.kopo.kopo12.boardWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	//annotation
public class HelloController {
	//컨트롤러 - > 요청이 들어오면 데이터 준비해서 /web-inf/views/hello.jsp에 연결 
	@RequestMapping(value = "/hello") // /hello로 url에 들어오면 (요청) [2]
	public String hellSpringBoot(Model model) {
		model.addAttribute("name", "홍길동");	//key , value
		return "hello";	//이것으로 대응하겠다. [1]
	}
	//hello.jsp [1] <- /hello[2]

}
