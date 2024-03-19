package com.restfulapi.co.dto;

import com.restfulapi.co.entity.Empleado;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetEmpleadoResponseDto extends ResponseBaseDto{

    private Empleado responseData;

    public GetEmpleadoResponseDto() {
    }

    public Empleado getResponseData() {
        return responseData;
    }

    public void setResponseData(Empleado responseData) {
        this.responseData = responseData;
    }

}
