package ycu.edu.ygc.web;

import lombok.Data;
import ycu.edu.ygc.constant.ServiceCode;

import java.io.Serializable;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/4 22:06
 */
@Data
public class JsonResult<T> implements Serializable {

    /**
     * 业务状态码
     */
    private String state;

    /**
     * 错误时的提示消息
     */
    private String message;

    /**
     * 成功时响应的数据
     */
    private T data;

    public JsonResult() {
    }

    private JsonResult(String state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public static JsonResult<Void> ok() {
        return ok(null);
    }

    public static <T> JsonResult<T> ok(T data) {
        return new JsonResult(ServiceCode.NETWORK_SUCCESS, "ok", data);
    }

    public static JsonResult<Void> fail(String state, String message) {
        return new JsonResult(state, message, null);
    }

}
