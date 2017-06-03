/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowCar.java
 * Package Name:com.bookcase.system.bookordermgmt.controller
 * Date:2017年5月23日上午7:58:40
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
import com.bookcase.system.bookcoremgmt.dto.bookcase.BookCaseReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcase.BookCaseReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcase.BookCaseRspBody;
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborrowcar.BookBorrowCarRspBody;
import com.bookcase.system.bookordermgmt.service.BookBorrowCarService;

/**
 * ClassName:BookBorrowCar <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午7:58:40 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="借书购物车信息")
@RestController
@Slf4j
public class BookBorrowCarController {

	@Autowired
	BookBorrowCarService borrowCarService;

	@RequestMapping(value = "/auth/bookborrowcars/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询借书购物车信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookBorrowCarRspBody>> findBookBorrowCars(
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookBorrowCarRspBody>> result = borrowCarService
				.findBookBorrowCars(page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询借书购物车信息(todo)")
	@RequestMapping(value = "/auth/bookborrowcars/{bookBorrowCarId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookBorrowCarId", dataType = "String", required = true, value = "作者信息Id", defaultValue = "") })
	public GeneralContentResult<BookBorrowCarRspBody> findBookBorrowCarById(
			@PathVariable("bookBorrowCarId") String bookBorrowCarId) {
		GeneralContentResult<BookBorrowCarRspBody> result = borrowCarService
				.findBookBorrowCarById(bookBorrowCarId);
		return result;
	}

	@ApiOperation(value = "创建借书购物车信息(todo)")
	@RequestMapping(value = "/auth/bookborrowcars", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookBorrowCar(
			@RequestBody BookBorrowCarReqBody bookBorrowCarReqBody) {
		GeneralContentResult<String> result = borrowCarService
				.createBookBorrowCar(bookBorrowCarReqBody);
		return result;
	}

	@ApiOperation(value = "更新借书购物车信息(todo)")
	@RequestMapping(value = "/auth/bookborrowcars/{bookBorrowCarId}", method = RequestMethod.PUT)
	public GeneralResult updateBookBorrowCar(
			@PathVariable("bookBorrowCarId") String bookBorrowCarId,
			@RequestBody BookBorrowCarReqBody bookBorrowCarReqBody) {
		GeneralResult result = borrowCarService
				.updateBookBorrowCar(bookBorrowCarId,
						bookBorrowCarReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除借书购物车信息(todo)")
	@RequestMapping(value = "/auth/bookborrowcars", method = RequestMethod.DELETE)
	public GeneralResult deleteBookBorrowCars(
			@RequestBody BookBorrowCarReqParam bookBorrowCarReqParam) {
		GeneralResult result = borrowCarService
				.deleteBookBorrowCars(bookBorrowCarReqParam);
		return result;
	}
	
}

