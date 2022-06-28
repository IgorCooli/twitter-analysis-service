package br.com.uniacademia.server.domain;

import br.com.uniacademia.server.domain.dataprovider.SimpleTextSentimentAnalysisDataProvider;
import br.com.uniacademia.server.entrypoint.domain.SimpleTextSentimentAnalysisUseCase;
import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleTextSentimentAnalysisUseCaseImpl implements SimpleTextSentimentAnalysisUseCase {

    private final SimpleTextSentimentAnalysisDataProvider dataProvider;

    @Autowired
    public SimpleTextSentimentAnalysisUseCaseImpl(SimpleTextSentimentAnalysisDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public AnalyzeSentimentResponse execute(String text) {
        return dataProvider.execute(text);
    }
}
