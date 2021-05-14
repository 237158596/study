package com.baomidou.ant.t1.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
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

    private LocalDateTime createAt;

    private String createBy;

    private LocalDateTime updateAt;

    private String updateBy;


}
