package kr.study.spring_ai.controller.openapi;

import java.util.List;

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
	@Operation(summary = "빠른계좌 전체리스트 조회")
	@GetMapping("/chat")
	public ApiResponse<String> getChatApi(
		@Parameter(description = "질문", example = "이소스에서더나은방법제안해줄래")
		@RequestParam(value = "message") String message
	) {
		return ApiResponse.success(chatService.getChatApi("message"));
	}
}
