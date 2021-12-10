package com.cloud.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author lw
 * @description 将返回的数据进行封装，封装成一个实体类
 * @date 2021-12-09 11:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommonResult<T> {

    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 返回是否调用成功
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
