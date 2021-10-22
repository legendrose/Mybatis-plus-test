package com.nj.mybatisplus.samples;

import com.baomidou.mybatisplus.annotation.TableField;
import com.nj.mybatisplus.samples.entity.TUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageUI implements Serializable {
    private static final long serialVersionUID = 1L;



    //查询总记录
    private Long total;

    //查询结果集
    private List rows;
}
