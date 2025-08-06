package kr.study.spring_ai.common.config;

import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class HotelLoader {

	private  final VectorStore vectorStore;
	private final JdbcClient jdbcClient;

	@Value("classpath:data.txt")
	Resource resource;



	//@PostConstruct
	public void init() throws Exception {
		Integer count=jdbcClient.sql("select count(*) from hotel_vector")
			.query(Integer.class)
			.single();
		System.out.println("No of Records in the PG Vector Store="+count);
		if(count==0){
			List<Document> documents = Files.lines(resource.getFile().toPath())
				.map(Document::new)
				.collect(Collectors.toList());
			TextSplitter textSplitter = new TokenTextSplitter();
			for(Document document : documents) {
				List<Document> splitteddocs = textSplitter.split(document);
				System.out.println("before adding document: " + document.getText());
				vectorStore.add(splitteddocs); //임베딩
				System.out.println("Added document: " + document.getText());
				Thread.sleep(1000); // 1초
			}
			System.out.println("Application is ready to Serve the Requests");
		}
	}
}