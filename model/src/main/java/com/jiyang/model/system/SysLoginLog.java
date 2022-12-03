package com.jiyang.model.system;

import com.jiyang.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

@Data
@ApiModel(description = "SysLoginLog")
@TableName("sys_login_log")
public class SysLoginLog extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "UserName")
	@TableField("username")
	private String username;

	@ApiModelProperty(value = "Login ip")
	@TableField("ipaddr")
	private String ipaddr;

	@ApiModelProperty(value = "Login Status")
	@TableField("status")
	private Integer status;

	@ApiModelProperty(value = "提示信息")
	@TableField("msg")
	private String msg;

	@ApiModelProperty(value = "访问时间")
	@TableField("access_time")
	private Date accessTime;

}