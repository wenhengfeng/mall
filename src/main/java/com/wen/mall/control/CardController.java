package com.wen.mall.control;

import com.wen.mall.model.Card;
import com.wen.mall.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController(value = "/card")
public class CardController {
    @Autowired
    private CardService cardService;
    /**
     * 添加商品到购物车
     */
    @RequestMapping(value = "/addCart/{userId}/{goodId}/{number}")
    public Map<String, Object> addCart(@PathVariable Integer userId,@PathVariable Integer goodId,@PathVariable Integer number){
        return cardService.add(userId,goodId,number);
    }
    /**
     * 查询购物车商品信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findCart/{userId}")
    public ResponseEntity<List<Card>> findCard(@PathVariable Integer userId){
        List<Card> cards = cardService.find(userId);
        return new ResponseEntity<List<Card>>(cards,HttpStatus.OK);
    }

}
