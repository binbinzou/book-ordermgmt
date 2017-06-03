/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowOrderDetailServiceImpl.java
 * Package Name:com.bookcase.system.bookordermgmt.service.impl
 * Date:2017年5月23日上午7:56:56
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.service.impl;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworderdetail.BookBorrowOrderDetailReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworderdetail.BookBorrowOrderDetailReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborroworderdetail.BookBorrowOrderDetailRspBody;
import com.bookcase.system.bookordermgmt.service.BookBorrowOrderDetailService;

/**
 * ClassName:BookBorrowOrderDetailServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午7:56:56 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookBorrowOrderDetailServiceImpl implements BookBorrowOrderDetailService{

	@Override
	public GeneralResult deleteBookBorrowOrderDetails(
			BookBorrowOrderDetailReqParam bookBorrowOrderDetailReqParam) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult updateBookBorrowOrderDetail(
			String bookBorrowOrderDetailId,
			BookBorrowOrderReqBody bookBorrowOrderDetailReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<String> createBookBorrowOrderDetail(
			BookBorrowOrderDetailReqBody bookBorrowOrderDetailReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<BookBorrowOrderDetailRspBody> findBookBorrowOrderDetailById(
			String bookBorrowOrderDetailId) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralPagingResult<List<BookBorrowOrderDetailRspBody>> findBookBorrowOrderDetails(
			String page, String size) {
		
		// TODO Auto-generated method stub
		return null;
	}

}

