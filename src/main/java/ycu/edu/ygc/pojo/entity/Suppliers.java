package ycu.edu.ygc.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName ygc_suppliers
 */
@Data
public class Suppliers implements Serializable {
    /**
     * 供货商代号
     */
    private Integer supplierId;

    /**
     * 供货商名称
     */
    private String supplierName;

    /**
     * 供货商地址
     */
    private String supplierAddress;

    /**
     * 供货商联系人
     */
    private String supplierContactName;

    /**
     * 供货商联系方式
     */
    private String supplierPhone;

    private static final long serialVersionUID = 1L;
}
