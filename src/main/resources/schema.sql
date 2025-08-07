-- 초기 백더 데이터 추가

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS vector;

-- hotel_vector 테이블
DROP TABLE IF EXISTS hotel_vector;
CREATE TABLE hotel_vector (
                              id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
                              content text,
                              embedding vector(1536),
                              metadata jsonb
);

-- pdf_vector 테이블
DROP TABLE IF EXISTS pdf_vector;
CREATE TABLE pdf_vector (
                            id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
                            content text,
                            embedding vector(1536),
                            metadata jsonb
);