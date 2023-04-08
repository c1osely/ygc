package ycu.edu.ygc.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName ygc_users
 */
@Data
public class Users implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 用户唯一id
     */
    private String uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 账户是否可用
     */
    private Integer active;

    /**
     * 联系电话
     */
    private String phone;

    private static final long serialVersionUID = 1L;
}
