package com.jh.vlog.controller;

import com.jh.vlog.common.ResponseResult;
import com.jh.vlog.common.ResultCode;
import com.jh.vlog.model.Card;
import com.jh.vlog.utils.DataUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CardController
 * @Description TODO
 * @Author apple
 * @Date 2020/12/3
 **/
@RestController
@RequestMapping(value = "api")
public class CardController {

    @GetMapping("cards")
    public ResponseResult getCard() {
        List<Card> cards = DataUtil.initCards();
        return ResponseResult.success(cards);
    }
}
