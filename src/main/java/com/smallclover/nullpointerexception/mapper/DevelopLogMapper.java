package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.DevelopLog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Amadeus
 * @date 2020-01-19
 */
@Mapper
@Repository
public interface DevelopLogMapper {

    @Select("SELECT * FROM develop_log")
    @Results(
            id = "developLog",
            value = {
                    @Result(property = "bugType", column = "bug_type"),
                    @Result(property = "createTime", column = "create_time")
            }
    )
    List<DevelopLog> selectAllDevelopLogs();

    @Insert("INSERT INTO develop_log (content, bug_type, author, create_time) " +
            "VALUES(#{content}, #{bugType}, #{author}, #{createTime})")
    long insertDevelopLog(DevelopLog developLog);

    @Select("SELECT COUNT(*) FROM develop_log")
    long getDevelopLogCount();
}
