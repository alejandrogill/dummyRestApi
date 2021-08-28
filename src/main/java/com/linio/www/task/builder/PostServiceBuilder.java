package com.linio.www.task.builder;

import com.linio.www.models.Employe;
import com.linio.www.task.PostService;

public class PostServiceBuilder {
    private String endPoint;
    private String resource;


    public PostServiceBuilder(String endPoint) {
        this.endPoint=endPoint;
    }

    public PostServiceBuilder inResource(String resource){
        this.resource=resource;
        return this;
    }
    public PostService andEmployed(Employe employe){
        return new PostService(endPoint, resource, employe);
    }
}
