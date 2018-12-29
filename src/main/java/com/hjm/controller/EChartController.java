package com.hjm.controller;

import com.hjm.bean.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;


@Controller
public class EChartController {

    // 默认访问index.html
    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","SpringBoot");

        return "/index";
    }

    // Echarts 默认值案例
    @RequestMapping("/e1")
    public String eChart1(){

        return "/e1_default";
    }

    // Echarts通过 Ajax 传值案例
    @RequestMapping("/e2")
    public String eChart2(){

        return "/e2_ajax";
    }

    // 负责给 Ajax 返回 Json 数据
    @RequestMapping("/e3")
    @ResponseBody
    public List<Bean> ajaxJson(){

        List<Bean> beans = new ArrayList<>();
        beans.add(new Bean("张三",5000.0));
        beans.add(new Bean("李四",4000.0));
        beans.add(new Bean("王五",7000.0));
        beans.add(new Bean("赵六",9000.0));
        beans.add(new Bean("田七",2000.0));
        beans.add(new Bean("王八",4000.0));
        beans.add(new Bean("石九",6000.0));

        return beans;
    }

}
