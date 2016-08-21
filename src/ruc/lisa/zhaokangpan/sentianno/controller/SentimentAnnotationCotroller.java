package ruc.lisa.zhaokangpan.sentianno.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ruc.lisa.zhaokangpan.sentianno.model.HouseWeibo;
import ruc.lisa.zhaokangpan.sentianno.service.SentimentAnnotationService;

@Controller
public class SentimentAnnotationCotroller {
	
	@Autowired
	private SentimentAnnotationService sentimentAnnotationService;
	
	@RequestMapping("/toPage.do")
	public ModelAndView toPage(){
		ModelAndView mav = new ModelAndView("mainpage");
		try{
			List<HouseWeibo> hwlist = new ArrayList<HouseWeibo>();
			hwlist = sentimentAnnotationService.toPage();
			mav.addObject("hwlist", hwlist);
			mav.addObject("lastId", hwlist.get(hwlist.size()-1).getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/showListByDate.do")
	public @ResponseBody List<HouseWeibo> showListByDate(String year, String month, String day){
		List<HouseWeibo> hwlist = new ArrayList<HouseWeibo>();
		try{
			hwlist = sentimentAnnotationService.showListByDate(year, month, day);
		}catch(Exception e){
			e.printStackTrace();
		}
		return hwlist;
	}
	
	@RequestMapping("/addListByRoller.do")
	public @ResponseBody List<HouseWeibo> addListByRoller(String lastId){
		List<HouseWeibo> hwlist = new ArrayList<HouseWeibo>();
		try{
			hwlist = sentimentAnnotationService.addListByRoller(lastId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return hwlist;
	}
	
	@RequestMapping("/addAnnotation.do")
	public @ResponseBody boolean addAnnotation(String tag, String id){
		boolean flag = false;
		try{
			flag = sentimentAnnotationService.addAnnotation(tag, id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	@RequestMapping("/judgeDay.do")
	public @ResponseBody List<String> judgeDay(String year,String month){
		List<String> daylist = new ArrayList<String>();
		try{
			daylist = sentimentAnnotationService.judgeDay(year, month);
		}catch(Exception e){
			e.printStackTrace();
		}
		return daylist;
	}
	
	@RequestMapping("/getWeiboByKeyword.do")
	public @ResponseBody List<HouseWeibo> getWeiboByKeyword(String keyword){
		List<HouseWeibo> hwlist = new ArrayList<HouseWeibo>();
		try{
			hwlist = sentimentAnnotationService.getWeiboByKeyword(keyword);
		}catch(Exception e){
			e.printStackTrace();
		}
		return hwlist;
	}
	
	@RequestMapping("/realTimeSearch.do")
	public @ResponseBody List<String> realTimeSearch(String search){
		List<String> rtslist = new ArrayList<String>();
		try{
			for(int i = 0 ; i < 100 ; i++){
				rtslist.add(String.valueOf(i));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rtslist;
	}
}
