package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

/** '.'
 * @author Administrator
 * @date 2019/11/27 0027 0:23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LabelService {

  @Autowired
  private LabelDao labelDao;

  @Autowired
  private IdWorker idWorker;

  /**
   * 查询所有标签
   *
   * @return
   */
  public List<Label> findAll() {
    return labelDao.findAll();
  }

  /**
   * 根据id获取标签
   *
   * @param id
   * @return
   */
  public Label findLabelById(String id) {
    return labelDao.findById(id).get();
  }

  /**
   * 添加标签,雪花算法每秒最大支持26万次，分布式id生成器
   *
   * @param label
   */
  public void addLabel(Label label) {
    label.setId(idWorker.nextId() + "");
    labelDao.save(label);
  }

  /**
   * 修改标签
   *
   * @param label
   */
  public void updateLabel(Label label) {
    labelDao.save(label);
  }

  /**
   * 删除标签
   *
   * @param id
   */
  public void deleteLabel(String id) {
    labelDao.deleteById(id);
  }

}
