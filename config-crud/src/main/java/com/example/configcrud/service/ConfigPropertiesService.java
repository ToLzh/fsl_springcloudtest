package com.example.configcrud.service;

import com.example.configcrud.bean.ConfigProperties;
import com.example.configcrud.dao.ConfigPropertiesDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConfigPropertiesService {

    @Resource
    private ConfigPropertiesDao cpd;

    public int insert(ConfigProperties u){
        return cpd.insert(u);
    };
    //删除
    public int delete(int id){
        return cpd.delete(id);
    };
    //修改
    public int update(ConfigProperties u){
        return cpd.update(u);
    };
    //查询all
    public List<ConfigProperties> query(){
        return cpd.query();
    };
    //根据id查询
    public ConfigProperties queryby(int id){
        return cpd.queryby(id);
    }
}
