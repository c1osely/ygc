package ycu.edu.ygc.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName ygc_storages
 */
@Data
public class Storages implements Serializable {
    /**
     *
     */
    private Integer sId;

    /**
     * 是否被使用，0表示未被使用
     */
    private Integer used;

    private static final long serialVersionUID = 1L;
}
