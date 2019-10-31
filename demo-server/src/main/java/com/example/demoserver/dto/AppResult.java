package com.example.demoserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by hlw on 2019/8/15.
 */
@Data
@Builder
@AllArgsConstructor
public class AppResult<T> {
    private String msg="请求成功";
    private boolean status;
    private String code="0000";
    private T data;

    public AppResult(){
        this.code="0000";
        this.status=true;
        this.msg ="请求成功";
    }

    public AppResult success(){
        this.code="0000";
        this.msg ="请求成功";
        return this;
    }

    public AppResult fail(String msg){
        this.code ="1000";
        this.msg =msg;
        return this;
    }

}
