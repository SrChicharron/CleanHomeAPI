package com.pandemuerto.CleanHome.model.bean.response;

import lombok.Data;

@Data
public class MessageResponseBean {
    private String message;

    public MessageResponseBean(String message) {
        this.message = message;
    }
    public MessageResponseBean() {
    }
}
