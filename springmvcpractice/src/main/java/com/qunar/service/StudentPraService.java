package com.qunar.service;

import com.qunar.bean.StudentPra;
import com.qunar.dao.StudnetPraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created With IDEA
 * User:ShuangCheng.Wang
 * Date:16-7-10
 * Time:下午8:22
 */
@Service
public class StudentPraService {
    @Autowired
    private StudnetPraMapper studnetPraMapper;

    public List<StudentPra> getStudents(){
        return studnetPraMapper.selectStudents();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void testTran()  {
        studnetPraMapper.deleteStudent(1);
        List<StudentPra> list = studnetPraMapper.selectStudents();
        StudentPra stu = new StudentPra("Man","Man");
        studnetPraMapper.saveStudent(stu);
        if(list.size()==0){
            throw new RuntimeException("不能没有数据，我要回滚");
        }
    }
}
