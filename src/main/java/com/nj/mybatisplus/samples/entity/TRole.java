package com.nj.mybatisplus.samples.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TRole implements Serializable {
    /**
    * roleId
    */
    private Long roleId;

    /**
    * name
    */
    private String name;

    /**
    * desc
    */
    private String desc;

    /**
    * userName
    */
    private String userName;

    private static final long serialVersionUID = 1L;
}