package com.smallclover.nullpointerexception.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/07/31 21:47
 */
@Data
public class BrowserDto {
    private List<String> labels;
    private DataSet dataSet;
}