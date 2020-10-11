package com.smallclover.nullpointerexception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * 访问数据
 * @Author: Amadeus
 * @Date: 2020/6/3 21:22
 */
@Data
//@AllArgsConstructor
public class VisitDto implements Serializable {
//    // pv 该url的总访问次数，每个ip一天次数只+1
//    private Map<String, String> pv;
//    // uv 页面总的ip访问数
//    private Set<String> uv;
//    // 热度，每次访问计数都+1
//    private Map<String, String> hot;

    private Map<Object, Object> time;

    private Map<Object, Object> aritcleCnt;
}
