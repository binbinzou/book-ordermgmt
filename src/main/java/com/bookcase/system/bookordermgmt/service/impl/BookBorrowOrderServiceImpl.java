/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowOrderServiceImpl.java
 * Package Name:com.bookcase.system.bookordermgmt.service.impl
 * Date:2017年5月23日上午7:52:10
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
import com.bookcase.system.bookordermgmt.constant.BookOrderdataMgmtConstant;
import com.bookcase.system.bookordermgmt.constant.BookOrderdataMgmtResultConstant;
import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowCar;
import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowOrder;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborroworder.BookBorrowOrderRspBody;
import com.bookcase.system.bookordermgmt.repository.OrderdataBookborrowOrderRepository;
import com.bookcase.system.bookordermgmt.service.BookBorrowOrderService;
import com.bookcase.system.bookordermgmt.utils.BookBorrowCarConverter;
import com.bookcase.system.bookordermgmt.utils.BookBorrowOrderConverter;

/**
 * ClassName:BookBorrowOrderServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午7:52:10 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookBorrowOrderServiceImpl implements BookBorrowOrderService {

	@Autowired
	OrderdataBookborrowOrderRepository orderdataBookborrowOrderRepository;
	
	@Override
	public GeneralPagingResult<List<BookBorrowOrderRspBody>> findBookBorrowOrders(
			String page, String size) {
		GeneralPagingResult<List<BookBorrowOrderRspBody>> result = new GeneralPagingResult<List<BookBorrowOrderRspBody>>();
		List<BookBorrowOrderRspBody> rspBodies = new ArrayList<BookBorrowOrderRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<OrderdataBookborrowOrder> pg = orderdataBookborrowOrderRepository
				.findBookBorrowOrders(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (OrderdataBookborrowOrder bookborrowOrder : pg.getContent()) {
				rspBodies.add(BookBorrowOrderConverter
								.bookborrowOrder2BookBorrowOrderRspBody(bookborrowOrder));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookBorrowOrderRspBody> findBookBorrowOrderById(
			String bookBorrowOrderId) {
		GeneralContentResult<BookBorrowOrderRspBody> result = new GeneralContentResult<BookBorrowOrderRspBody>();
		OrderdataBookborrowOrder bookborrowOrder  = orderdataBookborrowOrderRepository.findOne(bookBorrowOrderId);
		BookBorrowOrderRspBody rspBody = BookBorrowOrderConverter.bookborrowOrder2BookBorrowOrderRspBody(bookborrowOrder);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookBorrowOrder(
			BookBorrowOrderReqBody bookBorrowOrderReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		OrderdataBookborrowOrder bookborrowOrder = BookBorrowOrderConverter.bookBorrowOrderReqBody2OrderdataBookborrowOrder(bookBorrowOrderReqBody);
		bookborrowOrder.setCreator("XXX");
		bookborrowOrder.setStatus(BookOrderdataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookborrowOrder = orderdataBookborrowOrderRepository.save(bookborrowOrder);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookborrowOrder.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookBorrowOrder(String bookBorrowOrderId,
			BookBorrowOrderReqBody bookBorrowOrderReqBody) {
		GeneralResult result = new GeneralResult();
		OrderdataBookborrowOrder tmp = orderdataBookborrowOrderRepository.findBookBorrowOrderById(bookBorrowOrderId);
		if(tmp==null){
			result.setCode(BookOrderdataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		OrderdataBookborrowOrder bookborrowOrder = BookBorrowOrderConverter
				.bookBorrowOrderReqBody2OrderdataBookborrowOrder(bookBorrowOrderReqBody);
		bookborrowOrder.setStatus(BookOrderdataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookborrowOrder.setCreator("XXX");
		bookborrowOrder.setId(bookBorrowOrderId);
		bookborrowOrder = orderdataBookborrowOrderRepository
				.save(bookborrowOrder);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookBorrowOrders(
			BookBorrowOrderReqParam bookBorrowOrderReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookBorrowOrderReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookBorrowOrderReqParam.getIds()){
			int tmp = orderdataBookborrowOrderRepository.setStatusFor(BookOrderdataMgmtConstant.STATUS_GLOBAL_DELETED, id);
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

