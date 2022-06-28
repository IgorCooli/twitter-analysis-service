package br.com.uniacademia.server.entrypoint.domain;

import com.google.cloud.language.v1.AnalyzeSentimentResponse;

public interface SimpleTextSentimentAnalysisUseCase {
    AnalyzeSentimentResponse execute(String text);
}
