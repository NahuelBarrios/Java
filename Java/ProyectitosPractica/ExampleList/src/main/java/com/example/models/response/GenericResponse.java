package com.example.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;


public class GenericResponse {
    
    public boolean isOk;
    public int id;
    public String message;

    @JsonInclude(Include.NON_NULL)
    public List<ErrorItemInfo> errors = new ArrayList<>();
    
}
