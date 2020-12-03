package com.jh.vlog.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResponseResult
 * @Description TODO
 * @Author apple
 * @Date 2020/12/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseResult {
    private Integer code;
    private String msg;
    private Object data;
}
