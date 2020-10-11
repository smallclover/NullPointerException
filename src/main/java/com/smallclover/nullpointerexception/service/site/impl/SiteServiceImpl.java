package com.smallclover.nullpointerexception.service.site.impl;

import com.smallclover.nullpointerexception.dto.StatisticDto;
import com.smallclover.nullpointerexception.mapper.ArticleMapper;
import com.smallclover.nullpointerexception.mapper.AttachMapper;
import com.smallclover.nullpointerexception.mapper.CommentMapper;
import com.smallclover.nullpointerexception.mapper.DevelopLogMapper;
import com.smallclover.nullpointerexception.service.site.SiteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Amadeus
 * @date 2020-01-19
 */
@Slf4j
@Service
@AllArgsConstructor
public class SiteServiceImpl implements SiteService {

    // 文章Mapper
    private final ArticleMapper articleMapper;
    // 评论Mapper
    private final CommentMapper commentMapper;
    // 附件Mapper
    private final AttachMapper attachMapper;
    // 开发日志Mapper
    private final DevelopLogMapper developLogMapper;


    /**
     * 获取网站后台信息
     * @return
     */
    @Override
    public StatisticDto getStatistics() {
    //TODO 启用缓存，但不是redis，而是caffeine
        // 已发表的文章总数
        long articles = articleMapper.getArticleCount();
        long comments = commentMapper.getCommentCount();
        long attaches = attachMapper.getAttachCount();
        long developLogs = developLogMapper.getDevelopLogCount();
        var statisticDTO = new StatisticDto();
        statisticDTO.setArticles(articles);
        statisticDTO.setComments(comments);
        statisticDTO.setAttaches(attaches);
        statisticDTO.setDevelopLogs(developLogs);
        return statisticDTO;
    }
}
