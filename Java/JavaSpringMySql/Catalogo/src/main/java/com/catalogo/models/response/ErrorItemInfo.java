package com.catalogo.models.response;

public class ErrorItemInfo {
    
     public ErrorItemInfo(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String field;
    public String message;
    
}
