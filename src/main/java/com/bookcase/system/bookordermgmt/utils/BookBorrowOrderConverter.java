/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowOrderConverter.java
 * Package Name:com.bookcase.system.bookordermgmt.utils
 * Date:2017年6月4日下午4:44:51
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.utils;

import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowOrder;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqBody;
import com.bookcase.system.bookordermgmt.otd.bookborroworder.BookBorrowOrderRspBody;

/**
 * ClassName:BookBorrowOrderConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午4:44:51 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookBorrowOrderConverter {

	public static BookBorrowOrderRspBody bookborrowOrder2BookBorrowOrderRspBody(
			OrderdataBookborrowOrder bookborrowOrder) {
		BookBorrowOrderRspBody rspBody = new BookBorrowOrderRspBody();
		rspBody.setBookCnt(bookborrowOrder.getBookCnt());
		rspBody.setCreateTime(bookborrowOrder.getCreateTime());
		rspBody.setCreator(bookborrowOrder.getCreator());
		rspBody.setId(bookborrowOrder.getId());
		rspBody.setStatus(bookborrowOrder.getStatus());
		rspBody.setType(bookborrowOrder.getType());
		rspBody.setUpdateTime(bookborrowOrder.getUpdateTime());
		return rspBody;
	}

	public static OrderdataBookborrowOrder bookBorrowOrderReqBody2OrderdataBookborrowOrder(
			BookBorrowOrderReqBody bookBorrowOrderReqBody) {
		OrderdataBookborrowOrder bookborrowOrder = new OrderdataBookborrowOrder();
		bookborrowOrder.setBookCnt(bookBorrowOrderReqBody.getBookCnt());
		bookborrowOrder.setType(bookBorrowOrderReqBody.getType());
		return bookborrowOrder;
	}

}

