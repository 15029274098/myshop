package entity;

import java.util.List;

/** '封装分页查询结果.'
 * @author Administrator
 * @date 2019/11/27 0027 0:00
 */
public class PageResult<T> {
  private Long total;
  private List<T> rows;

  /**
   * 分页查询
   *
   * @param total
   * @param rows
   */
  public PageResult(Long total, List<T> rows) {
    this.total = total;
    this.rows = rows;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public List<T> getRows() {
    return rows;
  }

  public void setRows(List<T> rows) {
    this.rows = rows;
  }
}
