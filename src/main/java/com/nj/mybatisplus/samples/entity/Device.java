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
public class Device implements Serializable {
    private Long deviceid;

    private String devicecode;

    private String devicename;

    /**
    * 设备分组字段
    */
    private String devicegroup;

    private String devicedesc;

    private String lng;

    private String lat;

    private String address;

    private String devicetypecode;

    private String devicetypename;

    /**
    * 公司编号
    */
    private String compcode;

    private String compname;

    /**
    * 广告升级类型（1-平台升级，2-非平台升级）
    */
    private Byte adupgradetype;

    private Date createtime;

    private Date edittime;

    private String creator;

    private static final long serialVersionUID = 1L;
}