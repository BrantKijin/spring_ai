package kr.study.spring_ai.service.openapi;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatAskService {

	private final ChatModel chatModel;

	public String getResponse(String message){
		return chatModel.call(message);
	}

	public String getResponseOptions(String message){
		ChatResponse response = chatModel.call(
			new Prompt(
				message,
				OpenAiChatOptions.builder()
					.model("gpt-4o")
					.temperature(0.4)
					.build()
			));
		return response.getResult().getOutput().getText();
	}
}
