package kr.study.spring_ai.controller.openapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "OPEN_AI CHAT API 컨트롤러 ")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/open-ai")
@Slf4j
public class ChatController {
}
