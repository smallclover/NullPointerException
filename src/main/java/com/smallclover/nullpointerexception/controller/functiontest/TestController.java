package com.smallclover.nullpointerexception.controller.functiontest;

import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.ParseException;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;
import com.smallclover.nullpointerexception.dto.BrowserDto;
import com.smallclover.nullpointerexception.dto.DataSet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * @Author: Amadeus
 * @Date: 2020/07/28 21:45
 */
@RestController
@RequestMapping("/test/cache")
public class TestController {

    @RequestMapping("")
    public ResponseEntity index(HttpServletRequest request){
//        UserAgentParser userAgentParser = null;
//        try {
//            userAgentParser = new UserAgentService().loadParser();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        ;
//        String userAgent = request.getHeader("User-Agent");
//        Capabilities capabilities = userAgentParser.parse(userAgent);
//        return ResponseEntity.ok(capabilities);
        var browserDto = new BrowserDto();
//        browserDto.setLabels(Arrays.asList(
//                "Chrome",
//                "IE",
//                "FireFox",
//                "Safari",
//                "Opera",
//                "Navigator"));
//        DataSet dataSet = new DataSet();
//        dataSet.setBackgroundColor(Arrays.asList("#f56954", "#00a65a", "#f39c12", "#00c0ef", "#3c8dbc", "#d2d6de"));
//        dataSet.setData(Arrays.asList(700,500,400,600,300,100));
//        browserDto.setDataSet(dataSet);
        return ResponseEntity.ok(browserDto);
    }
}
