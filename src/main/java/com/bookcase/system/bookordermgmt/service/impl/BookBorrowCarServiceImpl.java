/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowCarServiceImpl.java
 * Package Name:com.bookcase.system.bookordermgmt.service.impl
 * Date:2017年5月23日上午8:01:44
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.service.impl;

import java.util.ArrayList;
import java.util.List;



import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookcase.common.bookcommon.contant.CommonResultCodeConstant;
import com.bookcase.common.system.bookframework.page.PageInfo;
import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookcoremgmt.otd.bookmsg.BookMsgRspBody;
import com.bookcase.system.bookordermgmt.constant.BookOrderdataMgmtConstant;
import com.bookcase.system.bookordermgmt.constant.BookOrderdataMgmtResultConstant;
import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowCar;
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborrowcar.BookBorrowCarReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborrowcar.BookBorrowCarRspBody;
import com.bookcase.system.bookordermgmt.repository.OrderdataBookborrowCarRepository;
import com.bookcase.system.bookordermgmt.service.BookBorrowCarService;
import com.bookcase.system.bookordermgmt.utils.BookBorrowCarConverter;

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
@Service
@Slf4j
public class BookBorrowCarServiceImpl implements BookBorrowCarService{

	@Autowired
	OrderdataBookborrowCarRepository orderdataBookborrowCarRepository;
	
	@Override
	public GeneralPagingResult<List<BookBorrowCarRspBody>> findBookBorrowCars(
			String page, String size) {
		GeneralPagingResult<List<BookBorrowCarRspBody>> result = new GeneralPagingResult<List<BookBorrowCarRspBody>>();
		List<BookBorrowCarRspBody> rspBodies = new ArrayList<BookBorrowCarRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<OrderdataBookborrowCar> pg = orderdataBookborrowCarRepository
				.findBookborrowCars(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (OrderdataBookborrowCar bookborrowCar : pg.getContent()) {
				rspBodies.add(BookBorrowCarConverter
								.bookborrowCar2BookBorrowCarRspBody(bookborrowCar));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookBorrowCarRspBody> findBookBorrowCarById(
			String bookBorrowCarId) {
		GeneralContentResult<BookBorrowCarRspBody> result = new GeneralContentResult<BookBorrowCarRspBody>();
		OrderdataBookborrowCar bookborrowCar  = orderdataBookborrowCarRepository.findOne(bookBorrowCarId);
		BookBorrowCarRspBody rspBody = BookBorrowCarConverter.bookborrowCar2BookBorrowCarRspBody(bookborrowCar);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookBorrowCar(
			BookBorrowCarReqBody bookBorrowCarReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		OrderdataBookborrowCar bookborrowCar = BookBorrowCarConverter.bookBorrowCarReqBody2OrderdataBookborrowCar(bookBorrowCarReqBody);
		bookborrowCar.setCreator("XXX");
		bookborrowCar.setStatus(BookOrderdataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookborrowCar = orderdataBookborrowCarRepository.save(bookborrowCar);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookborrowCar.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookBorrowCar(String bookBorrowCarId,
			BookBorrowCarReqBody bookBorrowCarReqBody) {
		GeneralResult result = new GeneralResult();
		OrderdataBookborrowCar tmp = orderdataBookborrowCarRepository.findBookBorrowCarById(bookBorrowCarId);
		if(tmp==null){
			result.setCode(BookOrderdataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		OrderdataBookborrowCar bookborrowCar = BookBorrowCarConverter
				.bookBorrowCarReqBody2OrderdataBookborrowCar(bookBorrowCarReqBody);
		bookborrowCar.setStatus(BookOrderdataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookborrowCar.setCreator("XXX");
		bookborrowCar.setId(bookBorrowCarId);
		bookborrowCar = orderdataBookborrowCarRepository
				.save(bookborrowCar);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookBorrowCars(
			BookBorrowCarReqParam bookBorrowCarReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookBorrowCarReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookBorrowCarReqParam.getIds()){
			int tmp = orderdataBookborrowCarRepository.setStatusFor(BookOrderdataMgmtConstant.STATUS_GLOBAL_DELETED, id);
			if(tmp>0){
				tmpSize++;
			}
		}
		if(size==tmpSize){
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("删除成功");
		}else if(size>tmpSize){
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("部分数据删除成功");
		}else if(tmpSize==0){
			result.setCode(BookOrderdataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("删除失败");
		}
		return result;
	}

}

