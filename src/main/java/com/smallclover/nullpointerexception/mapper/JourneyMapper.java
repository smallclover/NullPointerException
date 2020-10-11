package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.Journey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/5/14 17:57
 */
@Mapper
@Repository
public interface JourneyMapper {

    @Select("SELECT * FROM journey")
    @Results(id = "journey",value = {
            @Result(property = "makeTime", column = "make_time"),
            @Result(property = "picPath", column = "pic_path"),
            @Result(property = "deleteFlag", column = "delete_flag")
    })
    List<Journey> getAllJourneys();
}
