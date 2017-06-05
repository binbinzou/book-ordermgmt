/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowOrderDetailController.java
 * Package Name:com.bookcase.system.bookordermgmt.controller
 * Date:2017年5月23日上午7:53:56
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
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqParam;
import com.bookcase.system.bookordermgmt.dto.bookborroworderdetail.BookBorrowOrderDetailReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworderdetail.BookBorrowOrderDetailReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborroworder.BookBorrowOrderRspBody;
import com.bookcase.system.bookordermgmt.otd.bookborroworderdetail.BookBorrowOrderDetailRspBody;
import com.bookcase.system.bookordermgmt.service.BookBorrowOrderDetailService;
import com.bookcase.system.bookordermgmt.service.BookBorrowOrderService;

/**
 * ClassName:BookBorrowOrderDetailController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午7:53:56 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="借书细节订单信息")
@RestController
@Slf4j
public class BookBorrowOrderDetailController {

	@Autowired
	BookBorrowOrderDetailService bookBorrowOrderDetailService;

	@RequestMapping(value = "/auth/bookborroworderdetails/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询借书细节订单信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookBorrowOrderDetailRspBody>> findBookBorrowOrderDetails(
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookBorrowOrderDetailRspBody>> result = bookBorrowOrderDetailService
				.findBookBorrowOrderDetails(page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询借书细节订单信息(todo)")
	@RequestMapping(value = "/auth/bookborroworderdetails/{bookBorrowOrderDetailId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookBorrowOrderDetailId", dataType = "String", required = true, value = "作者信息Id", defaultValue = "") })
	public GeneralContentResult<BookBorrowOrderDetailRspBody> findBookBorrowOrderDetailById(
			@PathVariable("bookBorrowOrderDetailId") String bookBorrowOrderDetailId) {
		GeneralContentResult<BookBorrowOrderDetailRspBody> result = bookBorrowOrderDetailService
				.findBookBorrowOrderDetailById(bookBorrowOrderDetailId);
		return result;
	}

	@ApiOperation(value = "创建借书细节订单信息(todo)")
	@RequestMapping(value = "/auth/bookborroworderdetails", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookBorrowOrderDetail(
			@RequestBody BookBorrowOrderDetailReqBody bookBorrowOrderDetailReqBody) {
		GeneralContentResult<String> result = bookBorrowOrderDetailService
				.createBookBorrowOrderDetail(bookBorrowOrderDetailReqBody);
		return result;
	}

	@ApiOperation(value = "更新借书细节订单信息(todo)")
	@RequestMapping(value = "/auth/bookborroworderdetails/{bookBorrowOrderDetailId}", method = RequestMethod.PUT)
	public GeneralResult updateBookBorrowOrderDetail(
			@PathVariable("bookBorrowOrderDetailId") String bookBorrowOrderDetailId,
			@RequestBody BookBorrowOrderDetailReqBody bookBorrowOrderDetailReqBody) {
		GeneralResult result = bookBorrowOrderDetailService
				.updateBookBorrowOrderDetail(bookBorrowOrderDetailId,
						bookBorrowOrderDetailReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除借书细节订单信息(todo)")
	@RequestMapping(value = "/auth/bookborroworderdetails", method = RequestMethod.DELETE)
	public GeneralResult deleteBookBorrowOrderDetails(
			@RequestBody BookBorrowOrderDetailReqParam bookBorrowOrderDetailReqParam) {
		GeneralResult result = bookBorrowOrderDetailService
				.deleteBookBorrowOrderDetails(bookBorrowOrderDetailReqParam);
		return result;
	}
	
}

