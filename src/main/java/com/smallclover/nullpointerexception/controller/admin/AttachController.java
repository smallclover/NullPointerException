package com.smallclover.nullpointerexception.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smallclover.nullpointerexception.model.Article;
import com.smallclover.nullpointerexception.model.Attach;
import com.smallclover.nullpointerexception.service.attach.AttachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 附件管理
 * @author amadues
 * @date 2020-02-06
 */
@RequestMapping("admin/attach")
@Controller
@Slf4j
public class AttachController {

    private AttachService attachService;

    public AttachController(AttachService attachService) {
        this.attachService = attachService;
    }

    /**
     * 附件管理首页
     * @param page
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping(value = "")
    public String index(@RequestParam(required = true, defaultValue = "1") Integer page,
                        @RequestParam(required = true, defaultValue = "6") Integer pageSize,
                        Model model){
        PageHelper.startPage(page, pageSize);
        List<Attach> attachList = attachService.getAllAttach();
        var pageInfo = new PageInfo<>(attachList);
        model.addAttribute("attachList", attachList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/attach";
    }

    /**
     * 上传附件
     * @param files
     * @param request
     * @return
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public ResponseEntity filesUpload(
            @RequestParam(name = "files[]", required = true) MultipartFile[] files,
            HttpServletRequest request){
        log.info(String.valueOf(files.length));
        for (MultipartFile file : files) {
            log.info(file.getName());
        }
        return ResponseEntity.ok().body("success");
    }

}
