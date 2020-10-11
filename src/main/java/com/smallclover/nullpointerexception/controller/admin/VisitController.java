package com.smallclover.nullpointerexception.controller.admin;

import com.smallclover.nullpointerexception.dto.VisitDto;
import com.smallclover.nullpointerexception.dto.VisitReqDto;
import com.smallclover.nullpointerexception.service.visit.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @Author: Amadeus
 * @Date: 2020/6/3 21:30
 */
@Controller
@RequestMapping("/test")
@AllArgsConstructor
public class VisitController {

    VisitService visitService;

    @RequestMapping("/visit")
    public @ResponseBody
    VisitDto visit(VisitReqDto reqDTO){
        VisitDto visitDTO = new VisitDto();

        return visitDTO;
    }
}
