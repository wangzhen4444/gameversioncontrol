package com.mybitop.gameversioncontrol.service;

import com.mybitop.gameversioncontrol.entity.Hotupdatecheck;

import java.util.List;

public interface IHotUpdateCheck {

    int deleteHotupdatecheckById(Integer id);

    Hotupdatecheck findHotupdatecheckById(Integer id);

    List<Hotupdatecheck> findAll();

    Hotupdatecheck findHotupdatecheckByAppidAndChannelid(String appid, String channelid, String clientversion);

    Hotupdatecheck insert(Hotupdatecheck record);

    Hotupdatecheck update(Hotupdatecheck record);

//    int updateHotUpdateCheckOnlineById(String appname, String channelname, String appVersion, String updatestrategy, String baseurl, String apkurl, String promptcollection, String forcecollection, String excludecollection, String updateinfo, String id);

}
