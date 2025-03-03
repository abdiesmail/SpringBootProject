package com.example.QuizService.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Response {
    private Integer id;
    private String reponse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
}
