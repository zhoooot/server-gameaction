package com.zhoot.api.gameaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhoot.api.gameaction.model.*;
import com.zhoot.api.gameaction.service.AnswerService;
import com.zhoot.api.gameaction.service.QDataService;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private QDataService qDataService;

    @GetMapping("/{gameid}")
    Answer[] retrieveAllAnswer(@PathVariable String gameid) {
        return answerService.retrieveAllAnswer(gameid);
    }

    @GetMapping("/data/{gameid}")
    QData retrieveQData(@PathVariable String gameid) {
        return qDataService.retrieveQData(gameid);
    }

    @PostMapping("/data/{gameid}")
    QData addQData(@PathVariable String gameid, @RequestBody QData qdata) {
        return qDataService.addQData(gameid, qdata);
    }

    @PostMapping("/data/{gameid}/remove")
    void removeQData(@PathVariable String gameid) {
        qDataService.removeQData(gameid);
    }

    @PostMapping("/data/{gameid}/update")
    void updateQData(@PathVariable String gameid, @RequestBody QData qdata) {
        qDataService.updateQData(gameid, qdata);
    }

    @PostMapping("/{gameid}")
    Answer addAnswer(@PathVariable String gameid, @RequestBody Answer answer) {
        answerService.addAnswer(gameid, answer);
        return answer;
    }

    @PostMapping("/{gameid}/remove")
    void removeAnswer(@PathVariable String gameid, @RequestBody Answer answer) {
        answerService.removeAnswer(gameid, answer);
    }
}
