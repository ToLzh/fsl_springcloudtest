package com.example.configcrud.controller;

import com.example.configcrud.bean.ConfigProperties;
import com.example.configcrud.service.ConfigPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/properties")
public class ConfigPropertiesController {

    @Resource
    private ConfigPropertiesService us;

    //增加
    @RequestMapping("/insert")
    public String insert(ConfigProperties u){
        us.insert(u);
        return "redirect:/properties/query";   // 重定向
    }
    //删除
    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id")  int id){
        us.delete(id);
        //页面跳转到查询所有的页面
        return "redirect:/properties/query";  // 重定向
    }

    //修改
    @RequestMapping("/update")
    public String update(ConfigProperties u){
        us.update(u);
        return "redirect:/properties/query";
    }

    //查询所有
    @RequestMapping("/query")
    public String queryAll(Model model){
        List<ConfigProperties> list=us.query();
        model.addAttribute("list",list);
        return "all";
    }
    //根据id查询
    @RequestMapping("/qby")
    public String query(@RequestParam("id") int id,Model model){
        ConfigProperties u=us.queryby(id);
        //把这个user显示在页面上面
        model.addAttribute("user",u);
        return "update";
    }
    @RequestMapping("/addRequest")
    public String addRequest(Model model){
        ConfigProperties user = new ConfigProperties();
        model.addAttribute("user",user);
        return "insert";
    }

}
