package com.sean.ebusiness.repository.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sean.ebusiness.entity.Goods;
import com.sean.ebusiness.entity.GoodsType;

@Mapper
public interface TypeRepository {
	int selectAll();
	List<GoodsType> selectAllTypeByPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize);
	int selectTypeByName(String goodsTypeName);
	int deleteType(int id);
	List<Goods> selectGoods(int goodstype_id);
	int addType(GoodsType goodsType);
	List<GoodsType> searchGoodsType(String goodsTypeKey);
}
