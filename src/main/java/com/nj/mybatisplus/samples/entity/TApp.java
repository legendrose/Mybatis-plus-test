package com.nj.mybatisplus.samples.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TApp implements Serializable {
    private String appId;

    private String appName;

    private String appDesc;

    private String userName;

    private Date createDate;

    private static final long serialVersionUID = 1L;
}