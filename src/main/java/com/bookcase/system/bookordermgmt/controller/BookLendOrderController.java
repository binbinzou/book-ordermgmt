package com.bookcase.system.bookordermgmt.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookordermgmt.dto.booklendorder.BookLendOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.booklendorder.BookLendOrderReqParam;
import com.bookcase.system.bookordermgmt.otd.booklendorder.BookLendOrderRspBody;
import com.bookcase.system.bookordermgmt.service.BookLendOrderService;

@Api(value="租书主订单信息")
@RestController
@Slf4j
public class BookLendOrderController {

	@Autowired
	BookLendOrderService bookLendOrderService;

	@RequestMapping(value = "/auth/booklendorders/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询借书主订单信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookLendOrderRspBody>> findBookLendOrders(
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookLendOrderRspBody>> result = bookLendOrderService
				.findBookLendOrders(page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询借书主订单信息(todo)")
	@RequestMapping(value = "/auth/booklendorders/{bookLendOrderId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookLendOrderId", dataType = "String", required = true, value = "作者信息Id", defaultValue = "") })
	public GeneralContentResult<BookLendOrderRspBody> findBookLendOrderById(
			@PathVariable("bookLendOrderId") String bookLendOrderId) {
		GeneralContentResult<BookLendOrderRspBody> result = bookLendOrderService
				.findBookLendOrderById(bookLendOrderId);
		return result;
	}

	@ApiOperation(value = "创建借书主订单信息(todo)")
	@RequestMapping(value = "/auth/booklendorders", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookLendOrder(
			@RequestBody BookLendOrderReqBody bookLendOrderReqBody) {
		GeneralContentResult<String> result = bookLendOrderService
				.createBookLendOrder(bookLendOrderReqBody);
		return result;
	}

	@ApiOperation(value = "更新借书主订单信息(todo)")
	@RequestMapping(value = "/auth/booklendorders/{bookLendOrderId}", method = RequestMethod.PUT)
	public GeneralResult updateBookLendOrder(
			@PathVariable("bookLendOrderId") String bookLendOrderId,
			@RequestBody BookLendOrderReqBody bookLendOrderReqBody) {
		GeneralResult result = bookLendOrderService
				.updateBookLendOrder(bookLendOrderId,
						bookLendOrderReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除借书主订单信息(todo)")
	@RequestMapping(value = "/auth/booklendorders", method = RequestMethod.DELETE)
	public GeneralResult deleteBookLendOrders(
			@RequestBody BookLendOrderReqParam bookLendOrderReqParam) {
		GeneralResult result = bookLendOrderService
				.deleteBookLendOrders(bookLendOrderReqParam);
		return result;
	}
	
	
}
