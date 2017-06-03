/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowCarService.java
 * Package Name:com.bookcase.system.bookordermgmt.service
 * Date:2017年5月23日上午8:00:46
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborrowcar.BookBorrowCarRspBody;

/**
 * ClassName:BookBorrowCarService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:00:46 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookBorrowCarService {

	GeneralPagingResult<List<BookBorrowCarRspBody>> findBookBorrowCars(
			String page, String size);

	GeneralContentResult<BookBorrowCarRspBody> findBookBorrowCarById(
			String bookBorrowCarId);

	GeneralContentResult<String> createBookBorrowCar(
			BookBorrowCarReqBody bookBorrowCarReqBody);

	GeneralResult updateBookBorrowCar(String bookBorrowCarId,
			BookBorrowCarReqBody bookBorrowCarReqBody);

	GeneralResult deleteBookBorrowCars(
			BookBorrowCarReqParam bookBorrowCarReqParam);

}

