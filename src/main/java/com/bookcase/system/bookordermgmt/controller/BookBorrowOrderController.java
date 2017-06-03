/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowOrderController.java
 * Package Name:com.bookcase.system.bookordermgmt.controller
 * Date:2017年5月23日上午7:50:40
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

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
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqParam;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborrowcar.BookBorrowCarRspBody;
import com.bookcase.system.bookordermgmt.otd.bookborroworder.BookBorrowOrderRspBody;
import com.bookcase.system.bookordermgmt.service.BookBorrowCarService;
import com.bookcase.system.bookordermgmt.service.BookBorrowOrderService;

/**
 * ClassName:BookBorrowOrderController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午7:50:40 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="借书主订单信息")
@RestController
@Slf4j
public class BookBorrowOrderController {

	@Autowired
	BookBorrowOrderService bookBorrowOrderService;

	@RequestMapping(value = "/auth/bookborroworders/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询借书主订单信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookBorrowOrderRspBody>> findBookBorrowOrders(
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookBorrowOrderRspBody>> result = bookBorrowOrderService
				.findBookBorrowOrders(page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询借书主订单信息(todo)")
	@RequestMapping(value = "/auth/bookborroworders/{bookBorrowOrderId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookBorrowOrderId", dataType = "String", required = true, value = "作者信息Id", defaultValue = "") })
	public GeneralContentResult<BookBorrowOrderRspBody> findBookBorrowOrderById(
			@PathVariable("bookBorrowOrderId") String bookBorrowOrderId) {
		GeneralContentResult<BookBorrowOrderRspBody> result = bookBorrowOrderService
				.findBookBorrowOrderById(bookBorrowOrderId);
		return result;
	}

	@ApiOperation(value = "创建借书主订单信息(todo)")
	@RequestMapping(value = "/auth/bookborroworders", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookBorrowOrder(
			@RequestBody BookBorrowOrderReqBody bookBorrowOrderReqBody) {
		GeneralContentResult<String> result = bookBorrowOrderService
				.createBookBorrowOrder(bookBorrowOrderReqBody);
		return result;
	}

	@ApiOperation(value = "更新借书主订单信息(todo)")
	@RequestMapping(value = "/auth/bookborroworders/{bookBorrowOrderId}", method = RequestMethod.PUT)
	public GeneralResult updateBookBorrowOrder(
			@PathVariable("bookBorrowOrderId") String bookBorrowOrderId,
			@RequestBody BookBorrowOrderReqBody bookBorrowOrderReqBody) {
		GeneralResult result = bookBorrowOrderService
				.updateBookBorrowOrder(bookBorrowOrderId,
						bookBorrowOrderReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除借书主订单信息(todo)")
	@RequestMapping(value = "/auth/bookborroworders", method = RequestMethod.DELETE)
	public GeneralResult deleteBookBorrowOrders(
			@RequestBody BookBorrowOrderReqParam bookBorrowOrderReqParam) {
		GeneralResult result = bookBorrowOrderService
				.deleteBookBorrowOrders(bookBorrowOrderReqParam);
		return result;
	}
	
	
}

