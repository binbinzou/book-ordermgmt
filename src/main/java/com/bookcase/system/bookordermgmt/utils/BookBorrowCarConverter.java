/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowCarConverter.java
 * Package Name:com.bookcase.system.bookordermgmt.utils
 * Date:2017年6月4日下午4:43:10
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.utils;

import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowCar;
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqBody;
import com.bookcase.system.bookordermgmt.otd.bookborrowcar.BookBorrowCarRspBody;

/**
 * ClassName:BookBorrowCarConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午4:43:10 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookBorrowCarConverter {

	public static BookBorrowCarRspBody bookborrowCar2BookBorrowCarRspBody(
			OrderdataBookborrowCar bookborrowCar) {
		BookBorrowCarRspBody rspBody = new BookBorrowCarRspBody();
		rspBody.setCreateTime(bookborrowCar.getCreateTime());
		rspBody.setCreator(bookborrowCar.getCreator());
		rspBody.setId(bookborrowCar.getId());
		rspBody.setStatus(bookborrowCar.getStatus());
		rspBody.setUpdateTime(bookborrowCar.getUpdateTime());
		rspBody.setBookmsgId(bookborrowCar.getBookmsgId());
		return rspBody;
	}

	public static OrderdataBookborrowCar bookBorrowCarReqBody2OrderdataBookborrowCar(
			BookBorrowCarReqBody bookBorrowCarReqBody) {
		OrderdataBookborrowCar bookborrowCar = new OrderdataBookborrowCar();
		bookborrowCar.setBookmsgId(bookBorrowCarReqBody.getBookmsgId());
		return bookborrowCar;
	}

}

