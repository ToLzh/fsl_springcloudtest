package com.example.configcrud.dao;

import com.example.configcrud.bean.ConfigProperties;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ConfigPropertiesDao {
    //插入
    @Insert("insert into config_properties(key1,value1,application,`profile`,label) values (#{key1},#{value1},#{application},#{profile},#{label})")
    int insert(ConfigProperties u);
    //删除
    @Delete("delete from config_properties where id=#{id}")
    int delete(int id);
    //修改
    @Update("update config_properties set key1=#{key1},value1=#{value1},application=#{application},label=#{label},profile=#{profile} where id=#{id}")
    int update(ConfigProperties u);
    //查询all
    @Select("select * from config_properties")
    List<ConfigProperties> query();
    //根据id查询
    @Select("select * from config_properties where id=#{id}")
    ConfigProperties queryby(int id);
}
