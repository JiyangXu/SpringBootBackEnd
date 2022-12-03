package com.jiyang.model.system;

import com.jiyang.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Position")
@TableName("sys_post")
public class SysPost extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Position Code")
	@TableField("post_code")
	private String postCode;

	@ApiModelProperty(value = "Position Name")
	@TableField("name")
	private String name;

	@ApiModelProperty(value = "Order")
	@TableField("description")
	private String description;

	@ApiModelProperty(value = "状态（1正常 0停用）")
	@TableField("status")
	private Integer status;

}