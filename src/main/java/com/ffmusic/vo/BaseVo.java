package com.ffmusic.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BaseVo {
    private String id;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private Date createdTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private Date updatedTime;
}
