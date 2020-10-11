package com.smallclover.nullpointerexception.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/07/31 21:52
 */
@Data
public class DataSet {
    private List<Integer> data;
    private List<String> backgroundColor;
}
