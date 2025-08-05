package kr.study.spring_ai.service.openapi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import kr.study.spring_ai.common.constant.OpenAIPromptConstant;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {
	private final ChatClient.Builder chatClientBuilder;

	public String getDeveloperChatApi(String message) {

		ChatClient client = chatClientBuilder
			.defaultSystem(OpenAIPromptConstant.PROMPT_DEVELOPER)
			.build();

		return client.prompt()
			.user(message)
			.call()
			.content();

	}

	public String getSubjectChatApi(String message, String subject, String tone) {
		ChatClient client = chatClientBuilder
			.defaultSystem(OpenAIPromptConstant.PROMPT_SUBJECT)
			.build();

		return client.prompt()
			.user(message)
			.system(sp -> sp.param("subject", subject).param("tone", tone))
			.call()
			.content();

	}

}
