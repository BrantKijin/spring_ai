package kr.study.spring_ai.common.config;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.ai.vectorstore.pgvector.autoconfigure.PgVectorStoreProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class VectorStoreConfig {

	@Bean("hotelVectorStore")
	public PgVectorStore hotelVectorStore(JdbcTemplate jdbcTemplate, EmbeddingModel embeddingModel) {
		return PgVectorStore.builder(jdbcTemplate, embeddingModel)
			.vectorTableName("hotel_vector")
			.build();
	}

	@Bean("pdfVectorStore")
	public PgVectorStore pdfVectorStore(JdbcTemplate jdbcTemplate, EmbeddingModel embeddingModel) {
		return PgVectorStore.builder(jdbcTemplate, embeddingModel)
			.vectorTableName("pdf_vector")
			.build();
	}
}