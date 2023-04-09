package ycu.edu.ygc.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName ygc_categories
 */
@Data
public class Categories implements Serializable {
    /**
     * 种类代号
     */
    private Integer categoryId;

    /**
     * 种类名称
     */
    private String categoryName;

    /**
     * 
     */
    private Integer categoryEnabled;

    private static final long serialVersionUID = 1L;
}