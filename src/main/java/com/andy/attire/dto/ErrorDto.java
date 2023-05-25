package com.andy.attire.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ErrorDto {
    private Long id;
    private UUID reference;
    private String url;
    private String body;
    private String exceptionMessage;
    private String track;

    public ErrorDto(String url, String body, String exceptionMessage, String track) {
        this.url = url;
        this.body = body;
        this.exceptionMessage = exceptionMessage;
        this.track = track;
    }
}
