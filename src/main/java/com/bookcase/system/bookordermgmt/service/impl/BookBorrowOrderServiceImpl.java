/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowOrderServiceImpl.java
 * Package Name:com.bookcase.system.bookordermgmt.service.impl
 * Date:2017年5月23日上午7:52:10
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.service.impl;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborroworder.BookBorrowOrderRspBody;
import com.bookcase.system.bookordermgmt.service.BookBorrowOrderService;

/**
 * ClassName:BookBorrowOrderServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午7:52:10 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookBorrowOrderServiceImpl implements BookBorrowOrderService {

	@Override
	public GeneralPagingResult<List<BookBorrowOrderRspBody>> findBookBorrowOrders(
			String page, String size) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<BookBorrowOrderRspBody> findBookBorrowOrderById(
			String bookBorrowOrderId) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<String> createBookBorrowOrder(
			BookBorrowOrderReqBody bookBorrowOrderReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult updateBookBorrowOrder(String bookBorrowOrderId,
			BookBorrowOrderReqBody bookBorrowOrderReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult deleteBookBorrowOrders(
			BookBorrowOrderReqParam bookBorrowOrderReqParam) {
		
		// TODO Auto-generated method stub
		return null;
	}

}

