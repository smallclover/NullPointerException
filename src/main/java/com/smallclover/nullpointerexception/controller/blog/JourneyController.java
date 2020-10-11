package com.smallclover.nullpointerexception.controller.blog;

import com.smallclover.nullpointerexception.model.Journey;
import com.smallclover.nullpointerexception.service.journey.JourneyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 旅行日志
 * @Author: Amadeus
 * @Date: 2020/7/14 21:28
 */
@RequestMapping("/blog/journey")
@Controller
@AllArgsConstructor
public class JourneyController {

    private JourneyService journeyService;

    /**
     * 旅行日志首页
     * @return
     */
    @GetMapping("")
    public String journey(Model model){
        var journeys = journeyService.getAllJourneys();
        model.addAttribute("center", journeys.get(0));
        return "/blog/journey";
    }

    /**
     * 获取所有旅行记录
     * @return
     */
    @GetMapping("/all")
    public @ResponseBody
    List<Journey> getAllJourney(){
        return journeyService.getAllJourneys();
    }
}
