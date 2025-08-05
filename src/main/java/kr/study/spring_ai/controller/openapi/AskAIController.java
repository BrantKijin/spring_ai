package kr.study.spring_ai.controller.openapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.study.spring_ai.service.openapi.ChatAskService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AskAIController {
	private final ChatAskService chatAskService;

	@GetMapping("/ask")
	public String getResponse(@RequestParam("message") String message) {
		return chatAskService.getResponse(message);
	}

	@GetMapping("/ask-ai")
	public String getResponseOptions(@RequestParam("message") String message) {
		return chatAskService.getResponseOptions(message);
	}
}
