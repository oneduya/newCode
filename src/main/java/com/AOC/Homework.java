package com.AOC;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class Homework {

    @Value(value="how to calc 3+2 ?")
    private String content;

    public Homework(){}
    public Homework(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
