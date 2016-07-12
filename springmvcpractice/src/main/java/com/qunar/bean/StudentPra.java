package com.qunar.bean;

/**
 * Created With IDEA
 * User:ShuangCheng.Wang
 * Date:16-7-10
 * Time:下午8:15
 */
public class StudentPra {
    private int id;

    private String name;

    private String sex;

    public StudentPra(){}

    public StudentPra(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "StudentPra{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
