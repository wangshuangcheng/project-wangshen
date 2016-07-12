package com.qunar.dao;

import com.qunar.bean.StudentPra;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created With IDEA
 * User:ShuangCheng.Wang
 * Date:16-7-10
 * Time:下午8:16
 */
@Repository
public interface StudnetPraMapper {

    public StudentPra selectStudent(int id);

    public List<StudentPra> selectStudents();

    public int saveStudent(StudentPra studentPra);

    public int deleteStudent(int id);

    public int updateStudent(StudentPra studentPra);
}
