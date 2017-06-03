package com.bookcase.system.bookordermgmt.service.impl;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookordermgmt.dto.booklendorder.BookLendOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.booklendorder.BookLendOrderReqParam;
import com.bookcase.system.bookordermgmt.otd.booklendorder.BookLendOrderRspBody;
import com.bookcase.system.bookordermgmt.service.BookLendOrderService;

public class BookLendOrderServiceImpl implements BookLendOrderService {

	@Override
	public GeneralPagingResult<List<BookLendOrderRspBody>> findBookLendOrders(
			String page, String size) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<BookLendOrderRspBody> findBookLendOrderById(
			String bookLendOrderId) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<String> createBookLendOrder(
			BookLendOrderReqBody bookLendOrderReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult updateBookLendOrder(String bookLendOrderId,
			BookLendOrderReqBody bookLendOrderReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult deleteBookLendOrders(
			BookLendOrderReqParam bookLendOrderReqParam) {
		
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
