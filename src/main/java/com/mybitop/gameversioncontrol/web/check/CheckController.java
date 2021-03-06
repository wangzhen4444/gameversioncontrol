package com.mybitop.gameversioncontrol.web.check;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mybitop.gameversioncontrol.entity.Hotupdatecheck;
import com.mybitop.gameversioncontrol.service.IHotUpdateCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 版本检查开放接口
 */
@Controller
@RequestMapping("/check/")
public class CheckController {
    private static final Logger logger = LoggerFactory.getLogger(CheckController.class);
    @Autowired
    private IHotUpdateCheck hotupdatecheck;

    @RequestMapping(value = "getCheckInfo", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Hotupdatecheck getCheckInfo(@RequestParam(value = "appid", required = true) String appid,
                                       @RequestParam(value = "channelid", required = true) String channelid,
                                       @RequestParam(value = "appVersion", required = true) String appVersion) {
        logger.info("appid:  " + appid + "  channelid: " + channelid + "  appversion: " + appVersion);
        return hotupdatecheck.findHotupdatecheckByAppidAndChannelid(appid, channelid, appVersion);
    }

    @RequestMapping(value = "getCheckInfoByJson", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Hotupdatecheck getCheckInfoByJson(@RequestParam(value = "data", required = true) String data) {
        logger.info("value:  " + data);
        if(data == null || data.isEmpty()) return null;
        String appid;
        String channelid;
        String appVersion;
        try {
            JSONObject object = JSON.parseObject(data);
            appid = String.valueOf(object.getString("productId"));
            channelid = String.valueOf(object.getString("id"));
            appVersion = String.valueOf(object.getString("version"));

            return hotupdatecheck.findHotupdatecheckByAppidAndChannelid(appid, channelid, appVersion);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getCheckInfoById")
    @ResponseBody
    public Hotupdatecheck getCheckInfoById(@RequestParam(value = "id", required = true) int id) {
        logger.info("getConfigById: " + id);
        return hotupdatecheck.findHotupdatecheckById(id);
    }


}
