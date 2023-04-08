package ycu.edu.ygc.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @TableName messages
 */
@Data
public class Messages implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 【货物名】将在【日期】到期
     */
    private String detail;

    private static final long serialVersionUID = 1L;
}
