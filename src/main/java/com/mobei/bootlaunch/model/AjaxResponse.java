package com.mobei.bootlaunch.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("返回的响应实体类")
public class AjaxResponse {

    @ApiModelProperty("是否请求成功")
    private boolean isok;   //请求是否处理成功
    @ApiModelProperty("请求响应🐎")
    private int code;       //请求响应状态码（200、400、500）
    private String message; //请求结果描述信息
    private Object data;    //请求结果数据

    private AjaxResponse() {

    }

    //请求成功的响应:不带查询数据(用于删除、修改、新增接口)
    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    //请求成功的响应:带有查询数据(用于数据查询接口)
    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }
}
