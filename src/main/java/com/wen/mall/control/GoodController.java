package com.wen.mall.control;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wen.mall.dao.GoodMapper;
import com.wen.mall.model.Good;
import com.wen.mall.model.GoodVO;
import com.wen.mall.service.GoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.PagingJson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.SyncFailedException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController(value = "/good")
public class GoodController {
    private Logger logger = LoggerFactory.getLogger(GoodController.class);
    @Autowired
    private GoodService goodService;

    @Autowired
    private GoodMapper goodMapper;
    /**
     * 添加商品到购物车
     * @param goodName
     * @param goodPrice
     * @param goodStyle
     * @param goodRemaing
     * @return
     */
    @RequestMapping(value = "/addGood/{goodName}/{goodPrice}/{goodStyle}/{goodRemaing}")
    public Map<String,Object> addGood(@PathVariable String goodName, @PathVariable double goodPrice,
                                      @PathVariable String goodStyle,@PathVariable int goodRemaing){
        logger.info("添加商品："+"商品名称="+goodName+";商品价格="+goodPrice+";商品类型="+goodStyle+";商品数量="+goodRemaing);
        return goodService.addGood(new Good(goodName,goodPrice,goodStyle,goodRemaing));
    }
    /**
     * 查询商品（分页）
     * @param pageNum
     * @param showNum
     * @return
     */
    @RequestMapping(value ="/findGoods/{pageNum}/{showNum}" )
    public ResponseEntity<PagingJson<Good>> findGoods(@PathVariable Integer pageNum,@PathVariable Integer showNum){
        logger.info("获取商品信息： 页码="+pageNum+";数量="+showNum);
        int startNum = (pageNum-1)*showNum;
        PagingJson<Good> pagingJson = goodService.findGoods(new GoodVO(showNum,startNum));
        ResponseEntity<PagingJson<Good>> responseEntity = new ResponseEntity<PagingJson<Good>>(pagingJson,HttpStatus.OK);
        return  responseEntity;
    }
    /**
     * 根据商品id查询商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/findGoods/{id}")
    public ResponseEntity<Good> findGoods(@PathVariable Integer id){
        Good good = goodService.findGood(id);
        ResponseEntity<Good> responseEntity = new ResponseEntity<>(good,HttpStatus.OK);
        return  responseEntity;
    }

    @RequestMapping("/test/{page}/{show}")
    public void test(@PathVariable Integer page,@PathVariable Integer show){
        PageHelper.startPage(page, show);
        List<Good> appsList = goodMapper.selectWithPaging(new GoodVO());
        logger.info("goods["+appsList.toString()+"]");
        PageInfo<Good> appsPageInfo = new PageInfo<>(appsList);

    }



}
