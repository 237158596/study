package com.example.mybatisplus.t2.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 参数
 * </p>
 *
 * @author sailer
 * @since 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Params implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String pdsn;

    /**
     * 用户账号
     */
    private String userNumber;

    private String phone;

    /**
     * 会话id
     */
    private String sessionId;

    /**
     * json格式参数
     */
    private String param;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    private String createBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateAt;

    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;


}
