package entity;

/** '封装返回结果.'
 * @author Administrator
 * @date 2019/11/26 0026 23:56
 */
public class Result<T> {

  //是否成功
  private boolean flag;

  // 返回码
  private Integer code;

  //返回信息
  private String message;

  // 返回数据
  private T data;

  public Result() {
  }

  /**
   * 适用于增删改
   * @param flag
   * @param code
   * @param message
   */
  public Result(boolean flag, Integer code, String message) {
    this.flag = flag;
    this.code = code;
    this.message = message;
  }

  public Result(boolean flag, Integer code, String message, T data) {
    this.flag = flag;
    this.code = code;
    this.message = message;
    this.data = data;
  }


  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
