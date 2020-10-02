package com.sean.ebusiness.repository.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sean.ebusiness.entity.Goods;
import com.sean.ebusiness.entity.GoodsType;

@Mapper
public interface GoodsRepository {
	int addGoods(Goods goods);
	int updateGoods(Goods goods);
	Goods selectAGoods(Integer id);
	int selectAllGoods();
	List<GoodsType> selectAllGoodsType();
	List<Goods> selectAllGoodsByPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize);
	int  deleteAGoods(Integer id);
	List<Map<String, Object>> selectFocusGoods(Integer id);
	List<Map<String, Object>> selectCartGoods(Integer id);
	List<Map<String, Object>> selectOrderGoods(Integer id);
}
