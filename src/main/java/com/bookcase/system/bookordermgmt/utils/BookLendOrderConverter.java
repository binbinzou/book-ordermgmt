/**
 * Project Name:book-ordermgmt
 * File Name:BookLendOrderConverter.java
 * Package Name:com.bookcase.system.bookordermgmt.utils
 * Date:2017年6月4日下午4:45:10
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.utils;

import com.bookcase.system.bookordermgmt.domain.OrderdataBooklendOrder;
import com.bookcase.system.bookordermgmt.dto.booklendorder.BookLendOrderReqBody;
import com.bookcase.system.bookordermgmt.otd.booklendorder.BookLendOrderRspBody;

/**
 * ClassName:BookLendOrderConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午4:45:10 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookLendOrderConverter {

	public static BookLendOrderRspBody booklendOrder2BookLendOrderRspBody(
			OrderdataBooklendOrder booklendOrder) {
		BookLendOrderRspBody rspBody = new BookLendOrderRspBody();
		rspBody.setBookCnt(booklendOrder.getBookCnt());
		rspBody.setCreateTime(booklendOrder.getCreateTime());
		rspBody.setCreator(booklendOrder.getCreator());
		rspBody.setId(booklendOrder.getId());
		rspBody.setStatus(booklendOrder.getStatus());
		rspBody.setUpdateTime(booklendOrder.getUpdateTime());
		return rspBody;
	}

	public static OrderdataBooklendOrder bookLendOrderReqBody2OrderdataBooklendOrder(
			BookLendOrderReqBody bookLendOrderReqBody) {
		OrderdataBooklendOrder booklendOrder = new OrderdataBooklendOrder();
		booklendOrder.setBookCnt(bookLendOrderReqBody.getBookCnt());
		return booklendOrder;
	}

}

