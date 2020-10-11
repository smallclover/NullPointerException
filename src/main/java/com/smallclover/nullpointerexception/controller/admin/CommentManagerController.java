package com.smallclover.nullpointerexception.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smallclover.nullpointerexception.model.Article;
import com.smallclover.nullpointerexception.model.Comment;
import com.smallclover.nullpointerexception.service.article.ArticleService;
import com.smallclover.nullpointerexception.service.comment.CommentService;
import com.smallclover.nullpointerexception.service.mail.MailService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章管理
 * @author Amadeus
 * @date 2020-01-23
 */
@RequestMapping("/admin/comment/manager")
@Controller
@AllArgsConstructor
public class CommentManagerController {

    private CommentService commentService;
    // 发送邮件通知
    private MailService mailService;



    /**
     * 评论管理首页
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(@RequestParam(required = true, defaultValue = "1") Integer page,
                        @RequestParam(required = true, defaultValue = "10") Integer pageSize,
                        Model model){
        PageHelper.startPage(page, pageSize);
        List<Comment> comments = commentService.getAllComments();
        var pageInfo = new PageInfo<>(comments);
        model.addAttribute("comments", comments);
        model.addAttribute("pageInfo", pageInfo);

        return "/admin/comment_manager";
    }

    @PostMapping("/passAudit")
    public @ResponseBody ResponseEntity passAudit(@RequestParam long commentId){
        boolean result = commentService.updateAuditStatus(commentId);
        var comment = commentService.getCommentByCommentId(commentId);

        if (result && !StringUtils.isNotEmpty(comment.getReplyUserId())){
            //有回复发送邮件通知
            var subject = "Null Pointer Exception";
            // 异步 @EnableAsync
            mailService.sendMailMessage(comment.getEmail(), subject, comment.getContent());
        }

        if (result){
            return ResponseEntity.ok().body("success");
        }else{
            return ResponseEntity.badRequest().body("error");
        }
    }
}
