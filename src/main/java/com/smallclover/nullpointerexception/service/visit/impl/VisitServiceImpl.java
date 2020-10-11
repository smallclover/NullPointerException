package com.smallclover.nullpointerexception.service.visit.impl;

import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.ParseException;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;
import com.smallclover.nullpointerexception.dto.SiteAccessDto;
import com.smallclover.nullpointerexception.dto.UserAgentDto;
import com.smallclover.nullpointerexception.service.visit.VisitService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * @Author: Amadeus
 * @Date: 2020/6/3 21:35
 */
@Service
public class VisitServiceImpl implements VisitService {

    private RedisTemplate<String, Object> redisTemplate;

    public VisitServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    @Async
    public void addVisitRecord(SiteAccessDto siteAccessDto) {
        HashOperations hashOp = redisTemplate.opsForHash();
        String date = siteAccessDto.getDate().toLocalDate().toString();
        String page = siteAccessDto.getUrl();
        String ip = siteAccessDto.getIp();
        String key = date + page;
        if (Objects.isNull(hashOp.get(key, ip))){
            // 每个页面是否被指定的ip访问过
            hashOp.put(key, ip, 1);
            // pv
            hashOp.increment("pv-" + date, page, 1);
            // uv
            hashOp.put("uv-" + date, page, 1);
        }else {
            // pv
            hashOp.increment("pv-" + date, page, 1);
        }
    }

    @Override
    @Async
    public UserAgentDto getUserAgent(String userAgent) {
        UserAgentParser userAgentParser = null;
        try {
            userAgentParser = new UserAgentService().loadParser();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Capabilities capabilities = userAgentParser.parse(userAgent);
        return null;
    }
}
