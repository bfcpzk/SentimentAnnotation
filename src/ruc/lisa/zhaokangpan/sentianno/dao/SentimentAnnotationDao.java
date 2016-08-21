package ruc.lisa.zhaokangpan.sentianno.dao;

import java.util.List;

import ruc.lisa.zhaokangpan.sentianno.model.HouseWeibo;

public interface SentimentAnnotationDao {

	List<HouseWeibo> toPage();//进入首页，捞出一部分数据

	List<HouseWeibo> showListByDate(String time);//根据日期捞出一部分数据

	List<HouseWeibo> addListByRoller(String lastId);//滚轴下滑，加载出新的数据

	boolean addAnnotation(String tag, String id);//更改标注结果

	List<HouseWeibo> getWeiboByKeyword(String keyword);//根据关键词选择对应的微博信息

}
