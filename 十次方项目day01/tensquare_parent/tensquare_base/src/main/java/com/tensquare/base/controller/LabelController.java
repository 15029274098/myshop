package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** '.'
 * @author Administrator
 * @date 2019/11/27 0027 0:40
 */
@RestController
@RequestMapping("/label")
public class LabelController {

  @Autowired
  private LabelService labelService;


  /**
   * 查询所有标签
   *
   * @return
   */
  @GetMapping
  public Result<List> findAll() {
    return new Result<>(true, StatusCode.OK, "查询成功", labelService.findAll());
  }

  /**
   * 根据id获取标签
   *
   * @param labelId
   * @return
   */
  @GetMapping("/{labelId}")
  public Result<Label> findLabelById(@PathVariable("labelId") String labelId) {
    return new Result<>(true, StatusCode.OK, "查询标签成功", labelService.findLabelById(labelId));
  }

  /**
   * 添加标签,雪花算法每秒最大支持26万次，分布式id生成器
   *
   * @param label
   */
  @PostMapping
  public Result addLabel(@RequestBody Label label) {
    labelService.addLabel(label);
    return new Result(true, StatusCode.OK, "添加标签成功");
  }

  /**
   * 修改标签
   *
   * @param label
   */
  @PutMapping("/{labelId}")
  public Result updateLabel(@RequestBody Label label, @PathVariable("labelId") String labelId) {
    label.setId(labelId);
    labelService.updateLabel(label);
    return new Result(true, StatusCode.OK, "更新标签成功");
  }

  /**
   * 删除标签
   *
   * @param labelId
   */
  @DeleteMapping("/{labelId}")
  public Result deleteLabel(@PathVariable("labelId") String labelId) {
    labelService.deleteLabel(labelId);
    return new Result(true, StatusCode.OK, "删除标签成功");
  }
}
