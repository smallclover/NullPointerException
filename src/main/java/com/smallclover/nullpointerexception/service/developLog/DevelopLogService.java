package com.smallclover.nullpointerexception.service.developLog;

import com.smallclover.nullpointerexception.dto.DevelopLogDto;
import com.smallclover.nullpointerexception.model.DevelopLog;

import java.util.List;

/**
 * 开发日志
 * @author Amadeus
 * @date 2020-01-19
 */
public interface DevelopLogService {

    /**
     * 取得所有的开发日志
     * @return
     */
    List<DevelopLogDto> getAllDevelopLogs();

    /**
     * 插入一条开发日志
     * @param developLog
     * @return
     */
    boolean insertDevelopLog(DevelopLog developLog);
}
