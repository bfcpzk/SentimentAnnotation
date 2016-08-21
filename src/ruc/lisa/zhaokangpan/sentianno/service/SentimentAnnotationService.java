package ruc.lisa.zhaokangpan.sentianno.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ruc.lisa.zhaokangpan.sentianno.dao.SentimentAnnotationDao;
import ruc.lisa.zhaokangpan.sentianno.model.HouseWeibo;

@Service
public class SentimentAnnotationService {
	
	@Autowired
	private SentimentAnnotationDao sentimentAnnotationDao;

	public List<HouseWeibo> toPage() {
		List<HouseWeibo> hwlist = new ArrayList<HouseWeibo>();
		try{
			hwlist = sentimentAnnotationDao.toPage();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hwlist;
	}

	public List<HouseWeibo> showListByDate(String year, String month, String day) {
		List<HouseWeibo> hwlist = new ArrayList<HouseWeibo>();
		try{
			String time = "";
			time = year + "-" + month + "-" + day;
			hwlist = sentimentAnnotationDao.showListByDate(time);
		}catch(Exception e){
			e.printStackTrace();
		}
		return hwlist;
	}

	public List<HouseWeibo> addListByRoller(String lastId) {
		List<HouseWeibo> hwlist = new ArrayList<HouseWeibo>();
		try{
			hwlist = sentimentAnnotationDao.addListByRoller(lastId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return hwlist;
	}

	public boolean addAnnotation(String tag, String id) {
		boolean flag = false;
		try{
			flag = sentimentAnnotationDao.addAnnotation(tag, id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public List<String> judgeDay(String year, String month) {
		if(month.equals("01")){
			month = "1";
		}else if(month.equals("02")){
			month = "2";
		}else if(month.equals("03")){
			month = "3";
		}else if(month.equals("04")){
			month = "4";
		}else if(month.equals("05")){
			month = "5";
		}else if(month.equals("06")){
			month = "6";
		}else if(month.equals("07")){
			month = "7";
		}else if(month.equals("08")){
			month = "8";
		}else if(month.equals("09")){
			month = "9";
		}
		List<String> daylist = new ArrayList<String>();
		int tem_year = Integer.parseInt(year);
		int tem_month = Integer.parseInt(month);
		try{
			for(int i = 1 ; i <= 28 ; i++){
				if(i <= 9){
					daylist.add("0" + String.valueOf(i));
				}else{
					daylist.add(String.valueOf(i));
				}
			}
			if((tem_year % 4 == 0 && tem_year % 100 != 0) || tem_year % 400 == 0){//闰年
				if(tem_month == 1 || tem_month == 3 ||tem_month == 5 ||tem_month == 7 ||tem_month == 8 || tem_month == 10 ||tem_month == 12){
					daylist.add("29");
					daylist.add("30");
					daylist.add("31");
				}else if(tem_month == 4||tem_month == 6||tem_month == 9||tem_month == 11){
					daylist.add("29");
					daylist.add("30");
				}else{
					daylist.add("29");
				}
			}else{//平年
				if(tem_month == 1 || tem_month == 3 ||tem_month == 5 ||tem_month == 7 ||tem_month == 8 ||tem_month == 10 ||tem_month == 12){
					daylist.add("30");
					daylist.add("31");
				}else if(tem_month == 4||tem_month == 6||tem_month == 9||tem_month == 11){
					daylist.add("30");
				}else{
					;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return daylist;
	}

	public List<HouseWeibo> getWeiboByKeyword(String keyword) {
		List<HouseWeibo> hwlist = new ArrayList<HouseWeibo>();
		try{
			hwlist = sentimentAnnotationDao.getWeiboByKeyword(keyword);
		}catch(Exception e){
			e.printStackTrace();
		}
		return hwlist;
	}
}
