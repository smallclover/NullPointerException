package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.Attach;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/5/13 21:12
 */
@Mapper
@Repository
public interface AttachMapper {

    @Select("SELECT * FROM attach")
    @Results(id = "attach",value = {
            @Result(property = "fileType", column = "file_type"),
            @Result(property = "storagePath", column = "storage_path"),
            @Result(property = "deleteFlag", column = "delete_flag"),
            @Result(property = "uploadTime", column = "upload_time"),
    })
    List<Attach> getAllAttach();

    @Select("SELECT COUNT(*) FROM attach")
    long getAttachCount();
}
