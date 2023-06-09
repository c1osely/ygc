package ycu.edu.ygc.pojo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName ygc_goods
 */
@Data
public class Goods implements Serializable {
    /**
     * 货物id
     */
    private String gId;

    /**
     * 货物批次
     */
    private String gItemNum;

    /**
     * 货物类别id
     */
    private Integer categoryId;

    /**
     * 货物名称
     */
    private String gName;

    /**
     * 货物代称
     */
    private String gShortName;

    /**
     * 供货商代号
     */
    private Integer supplierId;

    /**
     * 货物产地
     */
    private String gMadein;

    /**
     * 保质期-天
     */
    private Date gLife;

    /**
     * 货物重量
     */
    private String gWeight;

    /**
     * 货物数量
     */
    private String gQuantity;

    /**
     * 货物存储
     */
    private Double gStorage;

    /**
     * 计量单位
     */
    private String gUnit;

    /**
     * 仓储id
     */
    private Integer sId;

    private static final long serialVersionUID = 1L;
}