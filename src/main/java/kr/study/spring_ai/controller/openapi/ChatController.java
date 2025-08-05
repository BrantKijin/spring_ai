package kr.study.spring_ai.controller.openapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.study.spring_ai.common.dto.ApiResponse;
import kr.study.spring_ai.service.openapi.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "OPEN_AI CHAT API 컨트롤러 ")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/open-ai")
@Slf4j
public class ChatController {

	private final ChatService chatService;

	@Operation(summary = "[GPT]개발자질문API")
	@GetMapping("/developer/chat")
	public ApiResponse<String> getDeveloperChatApi(
		@Parameter(description = "질문", example = "이소스에서더나은방법제안해줄래")
		@RequestParam(value = "message") String message
	) {
		return ApiResponse.success(chatService.getDeveloperChatApi(message));
	}

	@Operation(summary = "[GPT]주제질문API")
	@GetMapping("/subject/chat")
	public ApiResponse<String> getSubjectChatApi(
		@Parameter(description = "질문", example = "이소스에서더나은방법제안해줄래")
		@RequestParam(value = "message") String message,
		@Parameter(description = "주제", example = "주제")
		@RequestParam(value = "subject") String subject,
		@Parameter(description = "대탑하는음성톤", example = "톤")
		@RequestParam(value = "tone") String tone
	) {
		return ApiResponse.success(chatService.getSubjectChatApi(message, subject, tone));
	}
}
