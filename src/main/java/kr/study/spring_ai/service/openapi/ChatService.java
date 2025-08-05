package kr.study.spring_ai.service.openapi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import kr.study.spring_ai.common.constant.OpenAIPromptConstant;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {
	private final ChatClient.Builder chatClientBuilder;

	public String getChatApi(String message) {

		ChatClient client = chatClientBuilder
			.defaultSystem(OpenAIPromptConstant.PROMPT_DEVELOPER)
			.build();

		return client.prompt()
			.user(message).call()
			.content();

	}

}
