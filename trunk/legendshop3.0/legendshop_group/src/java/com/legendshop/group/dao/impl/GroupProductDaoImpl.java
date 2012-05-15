/*
 * 
 * LegendShop 多用户商城系统
 * 
 *  版权所有,并保留所有权利。
 * 
 */
package com.legendshop.group.dao.impl;

import java.util.List;

import com.legendshop.core.dao.impl.BaseDaoImpl;
import com.legendshop.group.dao.GroupProductDao;
import com.legendshop.model.entity.GroupProduct;
import com.legendshop.model.entity.Product;
import com.legendshop.util.AppUtils;

/**
 * The Class GroupProductDaoImpl.
 */
public class GroupProductDaoImpl extends BaseDaoImpl implements GroupProductDao {

	/* (non-Javadoc)
	 * @see com.legendshop.group.dao.GroupProductDao#getProductById(java.lang.Long)
	 */
	public Product getProductById(Long prodId) {
		return get(Product.class, prodId);
	}

	/* (non-Javadoc)
	 * @see com.legendshop.group.dao.GroupProductDao#updateProduct(com.legendshop.model.entity.GroupProduct)
	 */
	public void updateProduct(GroupProduct product) {
		update(product);
	}

	/* (non-Javadoc)
	 * @see com.legendshop.group.dao.GroupProductDao#saveProduct(com.legendshop.model.entity.GroupProduct)
	 */
	public void saveProduct(GroupProduct product) {
		save(product);
	}
	
	/* (non-Javadoc)
	 * @see com.legendshop.group.dao.GroupProductDao#getGroupProduct(java.lang.Long)
	 */
	public GroupProduct getGroupProduct(Long prodId){
		String strHQL = "select p,g from Product p, GroupProduct g where p.prodId = g.prodId and p.prodId = ?";
		List<Object[]> list = findByHQL(strHQL, prodId);
		if(AppUtils.isNotBlank(list)){
			Product p = (Product)list.get(0)[0];
			GroupProduct g = (GroupProduct)list.get(0)[1];
			g.setProduct(p);
			return g;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.legendshop.group.dao.GroupProductDao#deleteProduct(java.lang.Long)
	 */
	public void deleteProduct(Long prodId) {
		deleteById(GroupProduct.class, prodId);
	}

}