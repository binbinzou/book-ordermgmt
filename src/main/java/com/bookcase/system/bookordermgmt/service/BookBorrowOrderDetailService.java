/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowOrderDetailService.java
 * Package Name:com.bookcase.system.bookordermgmt.service
 * Date:2017年5月23日上午7:56:28
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworderdetail.BookBorrowOrderDetailReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworderdetail.BookBorrowOrderDetailReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborroworderdetail.BookBorrowOrderDetailRspBody;

/**
 * ClassName:BookBorrowOrderDetailService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午7:56:28 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookBorrowOrderDetailService {

	GeneralResult deleteBookBorrowOrderDetails(
			BookBorrowOrderDetailReqParam bookBorrowOrderDetailReqParam);

	GeneralResult updateBookBorrowOrderDetail(String bookBorrowOrderDetailId,
			BookBorrowOrderReqBody bookBorrowOrderDetailReqBody);

	GeneralContentResult<String> createBookBorrowOrderDetail(
			BookBorrowOrderDetailReqBody bookBorrowOrderDetailReqBody);

	GeneralContentResult<BookBorrowOrderDetailRspBody> findBookBorrowOrderDetailById(
			String bookBorrowOrderDetailId);

	GeneralPagingResult<List<BookBorrowOrderDetailRspBody>> findBookBorrowOrderDetails(
			String page, String size);

}

