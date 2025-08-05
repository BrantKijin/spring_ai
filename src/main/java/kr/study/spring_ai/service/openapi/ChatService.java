package kr.study.spring_ai.service.openapi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatService {
	private final ChatClient.Builder chatClientBuilder;

	// OpenAIPromptConstant

	/*
	public String chat(String userInput) {
        ChatClient client = chatClientBuilder
            .defaultSystem("당신은 교육 튜터입니다...")
            .build();

        return client.prompt()
            .user(userInput)
            .call()
            .content();
    }
	 */
}
