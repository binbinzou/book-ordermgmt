/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowOrderService.java
 * Package Name:com.bookcase.system.bookordermgmt.service
 * Date:2017年5月23日上午7:51:34
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborroworder.BookBorrowOrderRspBody;

/**
 * ClassName:BookBorrowOrderService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午7:51:34 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookBorrowOrderService {

	GeneralPagingResult<List<BookBorrowOrderRspBody>> findBookBorrowOrders(
			String page, String size);

	GeneralContentResult<BookBorrowOrderRspBody> findBookBorrowOrderById(
			String bookBorrowOrderId);

	GeneralContentResult<String> createBookBorrowOrder(
			BookBorrowOrderReqBody bookBorrowOrderReqBody);

	GeneralResult updateBookBorrowOrder(String bookBorrowOrderId,
			BookBorrowOrderReqBody bookBorrowOrderReqBody);

	GeneralResult deleteBookBorrowOrders(
			BookBorrowOrderReqParam bookBorrowOrderReqParam);

}

