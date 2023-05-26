package com.andy.attire.entity.resultset;

import lombok.Data;


@Data
public class ResultSet {
    public ResultSet(Long id, String imgUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
    }

    private Long id;
    private String imgUrl;

}
