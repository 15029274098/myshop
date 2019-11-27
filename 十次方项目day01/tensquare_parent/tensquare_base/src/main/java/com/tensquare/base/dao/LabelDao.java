package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/** 'JpaRepository基本操作，JpaSpecificationExecutor复杂的查询.'
 * @author Administrator
 * @date 2019/11/27 0027 0:21
 */
@Repository
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {

}
