package ycu.edu.ygc.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @TableName goods_storages
 */
@Data
public class GoodsStorages implements Serializable {
    /**
     *
     */
    private Integer gId;

    /**
     *
     */
    private Integer sId;

    private static final long serialVersionUID = 1L;
}
