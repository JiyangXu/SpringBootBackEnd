package com.jiyang.model.system;

import com.jiyang.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Roel Menu")
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Role id")
	@TableField("role_id")
	private String roleId;

	@ApiModelProperty(value = "Menu id")
	@TableField("menu_id")
	private String menuId;

}

