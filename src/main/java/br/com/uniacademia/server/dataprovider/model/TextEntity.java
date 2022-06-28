package br.com.uniacademia.server.dataprovider.model;

import com.google.cloud.language.v1.Entity;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Data
@ToString
public class TextEntity {

    private String name;
    private Object type;
    private Map<String, String> metadata;
    private BigDecimal salience;
    private BigDecimal sentiment;

    public static TextEntity create(Entity entity) {
        var textEntity = new TextEntity();
        textEntity.setName(entity.getName());
        textEntity.setType(entity.getType());
        textEntity.setMetadata(entity.getMetadataMap());
        textEntity.setSalience(BigDecimal.valueOf(entity.getSalience()).setScale(10, RoundingMode.HALF_UP));
        textEntity.setSentiment(null);

        return textEntity;
    }
}
