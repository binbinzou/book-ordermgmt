/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowOrderDetailConverter.java
 * Package Name:com.bookcase.system.bookordermgmt.utils
 * Date:2017年6月4日下午4:44:31
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.utils;

import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowOrderdetail;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworderdetail.BookBorrowOrderDetailReqBody;
import com.bookcase.system.bookordermgmt.otd.bookborroworderdetail.BookBorrowOrderDetailRspBody;

/**
 * ClassName:BookBorrowOrderDetailConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午4:44:31 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookBorrowOrderDetailConverter {

	public static BookBorrowOrderDetailRspBody bookborrowOrderdetail2BookBorrowOrderDetailRspBody(
			OrderdataBookborrowOrderdetail bookborrowOrderdetail) {
		BookBorrowOrderDetailRspBody rspBody = new BookBorrowOrderDetailRspBody();
		rspBody.setBookborrowOrderid(bookborrowOrderdetail.getBookborrowOrderid());
		rspBody.setBookcaseFromid(bookborrowOrderdetail.getBookcaseFromid());
		rspBody.setBookcaseToid(bookborrowOrderdetail.getBookcaseToid());
		rspBody.setBookmsgId(bookborrowOrderdetail.getBookmsgId());
		rspBody.setCreateTime(bookborrowOrderdetail.getCreateTime());
		rspBody.setCreator(bookborrowOrderdetail.getCreator());
		rspBody.setId(bookborrowOrderdetail.getId());
		rspBody.setStatus(bookborrowOrderdetail.getStatus());
		rspBody.setUpdateTime(bookborrowOrderdetail.getUpdateTime());
		return rspBody;
	}

	public static OrderdataBookborrowOrderdetail bookBorrowOrderDetailReqBody2OrderdataBookborrowOrderdetail(
			BookBorrowOrderDetailReqBody bookBorrowOrderDetailReqBody) {
		OrderdataBookborrowOrderdetail bookborrowOrderdetail = new OrderdataBookborrowOrderdetail();
		bookborrowOrderdetail.setBookborrowOrderid(bookBorrowOrderDetailReqBody.getBookborrowOrderid());
		bookborrowOrderdetail.setBookcaseFromid(bookBorrowOrderDetailReqBody.getBookcaseFromid());
		bookborrowOrderdetail.setBookcaseToid(bookBorrowOrderDetailReqBody.getBookcaseToid());
		bookborrowOrderdetail.setBookmsgId(bookBorrowOrderDetailReqBody.getBookmsgId());
		// TODO Auto-generated method stub
		return bookborrowOrderdetail;
	}

}

