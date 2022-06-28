package br.com.uniacademia.server.dataprovider.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private Long userId;
    private String userName;
    private String userLocation;
    private Object coordinates;
    private String userUrl;
    private Integer userFollowersCounts;
    private Integer userFavouritesCount;
    private Integer userStatusesCount;
    private String userCreatedAt;

}
