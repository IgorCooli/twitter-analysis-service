package br.com.uniacademia.server.domain.dataprovider;

import com.google.cloud.language.v1.AnalyzeSentimentResponse;

public interface SimpleTextSentimentAnalysisDataProvider {
    AnalyzeSentimentResponse execute(String text);
}
