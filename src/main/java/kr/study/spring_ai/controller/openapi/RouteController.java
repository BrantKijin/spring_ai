package kr.study.spring_ai.controller.openapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "OPEN_AI CHAT View")
@RequiredArgsConstructor
@Controller
public class RouteController {

	@GetMapping("/askview")
	public String askview() {
		return "ask";
	}

	@GetMapping("/imageview")
	public String imageview() {
		return "image"; // image.html
	}

	@GetMapping("/imageview/voice")
	public String imageviewVoice(){
		return "imagev"; // image.html
	}

	@GetMapping("/imageview/text")
	public String imageviewText(){
		return "imageview";
	}

}
