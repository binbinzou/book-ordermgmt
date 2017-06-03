/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowCarServiceImpl.java
 * Package Name:com.bookcase.system.bookordermgmt.service.impl
 * Date:2017年5月23日上午8:01:44
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.service.impl;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborrowcar.BookBorrowCarRspBody;
import com.bookcase.system.bookordermgmt.service.BookBorrowCarService;

/**
 * ClassName:BookBorrowCarServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:01:44 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookBorrowCarServiceImpl implements BookBorrowCarService{

	@Override
	public GeneralPagingResult<List<BookBorrowCarRspBody>> findBookBorrowCars(
			String page, String size) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<BookBorrowCarRspBody> findBookBorrowCarById(
			String bookBorrowCarId) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<String> createBookBorrowCar(
			BookBorrowCarReqBody bookBorrowCarReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult updateBookBorrowCar(String bookBorrowCarId,
			BookBorrowCarReqBody bookBorrowCarReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult deleteBookBorrowCars(
			BookBorrowCarReqParam bookBorrowCarReqParam) {
		
		// TODO Auto-generated method stub
		return null;
	}

}

