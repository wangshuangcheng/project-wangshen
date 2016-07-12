package com.qunar.controller;

import com.qunar.bean.StudentPra;
import com.qunar.service.StudentPraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created With IDEA
 * User:ShuangCheng.Wang
 * Date:16-7-10
 * Time:下午8:24
 */
@Controller
@RequestMapping("stu/")
public class StudentController {
    @Autowired
    private StudentPraService studentPraService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "gets",method = RequestMethod.GET)
    public String test1(){
        List<StudentPra> list = studentPraService.getStudents();
        logger.info(list.toString());
        return "index";
    }

    @Transactional
    @RequestMapping(value = "testTran",method = RequestMethod.GET)
    public String test2() throws Exception {
        studentPraService.testTran();
        return "index";
    }

}
