package ruc.lisa.zhaokangpan.sentianno.dao.imp;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ruc.lisa.zhaokangpan.sentianno.dao.SentimentAnnotationDao;
import ruc.lisa.zhaokangpan.sentianno.model.HouseWeibo;

public class SentimentAnnotationDaoImp implements SentimentAnnotationDao{
	
	private JdbcTemplate jdbcTemplate;    
	
	public JdbcTemplate getJdbcTemplate() {  
		return jdbcTemplate;  
	}  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<HouseWeibo> toPage() {
		List<HouseWeibo> result=null;
        String sql = "select * from weibo_meta_data limit 100";
        try{
            result = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(HouseWeibo.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HouseWeibo> showListByDate(String time) {
		List<HouseWeibo> result=null;
        String sql = "select * from weibo_meta_data where date>='" + time + "' limit 100";
        try{
            result = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(HouseWeibo.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<HouseWeibo> addListByRoller(String lastId) {
		List<HouseWeibo> result=null;
        String sql = "select * from weibo_meta_data where id>'" + lastId + "' limit 100";
        try{
            result = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(HouseWeibo.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	@Override
	public boolean addAnnotation(String tag, String id) {
		boolean result = true;
		String sql = "update weibo_meta_data set sent_label='" + tag + "' where id='" + id + "';";
		try{
            getJdbcTemplate().execute(sql);
        }catch (Exception e){
            result=false;
            e.printStackTrace();
        }
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<HouseWeibo> getWeiboByKeyword(String keyword) {
		List<HouseWeibo> result=null;
        String sql = "select * from weibo_meta_data where text like '%" + keyword + "%' limit 100";
        try{
            result = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(HouseWeibo.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

}
