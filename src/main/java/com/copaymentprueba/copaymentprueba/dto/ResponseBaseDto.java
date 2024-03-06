package com.copaymentprueba.copaymentprueba.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBaseDto {

    private String responseCode;
    private String responseMessage;

    public ResponseBaseDto() {
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
