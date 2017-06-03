package com.bookcase.system.bookordermgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookordermgmt.dto.booklendorder.BookLendOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.booklendorder.BookLendOrderReqParam;
import com.bookcase.system.bookordermgmt.otd.booklendorder.BookLendOrderRspBody;

public interface BookLendOrderService {

	GeneralPagingResult<List<BookLendOrderRspBody>> findBookLendOrders(
			String page, String size);

	GeneralContentResult<BookLendOrderRspBody> findBookLendOrderById(
			String bookLendOrderId);

	GeneralContentResult<String> createBookLendOrder(
			BookLendOrderReqBody bookLendOrderReqBody);

	GeneralResult updateBookLendOrder(String bookLendOrderId,
			BookLendOrderReqBody bookLendOrderReqBody);

	GeneralResult deleteBookLendOrders(
			BookLendOrderReqParam bookLendOrderReqParam);

}
