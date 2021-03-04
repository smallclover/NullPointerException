package com.smallclover.nullpointerexception.service.developLog.impl;

import com.smallclover.nullpointerexception.dto.DevelopLogDto;
import com.smallclover.nullpointerexception.mapper.DevelopLogMapper;
import com.smallclover.nullpointerexception.model.DevelopLog;
import com.smallclover.nullpointerexception.service.developLog.DevelopLogService;
import com.smallclover.nullpointerexception.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Amadeus
 * @date 2020-01-19
 */
@Service
@Slf4j
public class DevelopLogServiceImpl implements DevelopLogService {

    private DevelopLogMapper developLogMapper;

    public DevelopLogServiceImpl(DevelopLogMapper developLogMapper) {
        this.developLogMapper = developLogMapper;
    }

    @Override
    public List<DevelopLogDto> getAllDevelopLogs() {
        List<DevelopLog> developLogList = developLogMapper.selectAllDevelopLogs();

        List<DevelopLogDto> developLogDtoList = developLogList.stream().map(siteLog -> {
            String timeAgo = TimeUtils.getFewTimeAgo(siteLog.getCreateTime());
            var developLogDto = new DevelopLogDto();
            developLogDto.setId(siteLog.getId());
            developLogDto.setBugType(siteLog.getBugType());
            developLogDto.setAuthor(siteLog.getAuthor());
            developLogDto.setCreateTime(siteLog.getCreateTime());
            developLogDto.setTimeAgo(timeAgo);
            List<String> content = Arrays.asList(siteLog.getContent().split(","));
            developLogDto.setContent(content);
            return developLogDto;
        }).collect(Collectors.toList());
        return developLogDtoList;
    }

    @Override
    public boolean insertDevelopLog(DevelopLog developLog) {
        long count = developLogMapper.insertDevelopLog(developLog);
        if(count > 0){
            return true;
        }
        return false;
    }
}
