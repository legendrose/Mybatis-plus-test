package com.nj.mybatisplus.samples.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TUser {//调度
    /**
    * 主键
    */
    private Long id;

    /**
    * 名称
    */
    private String name;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 电子邮箱
    */
    private String email;


    private transient String total;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}