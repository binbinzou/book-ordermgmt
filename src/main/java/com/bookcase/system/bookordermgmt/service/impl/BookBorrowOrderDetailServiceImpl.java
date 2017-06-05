/**
 * Project Name:book-ordermgmt
 * File Name:BookBorrowOrderDetailServiceImpl.java
 * Package Name:com.bookcase.system.bookordermgmt.service.impl
 * Date:2017年5月23日上午7:56:56
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

import com.bookcase.common.bookcommon.contant.CommonResultCodeConstant;
import com.bookcase.common.system.bookframework.page.PageInfo;
import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookordermgmt.constant.BookOrderdataMgmtConstant;
import com.bookcase.system.bookordermgmt.constant.BookOrderdataMgmtResultConstant;
import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowCar;
import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowOrderdetail;
import com.bookcase.system.bookordermgmt.dto.bookborroworder.BookBorrowOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworderdetail.BookBorrowOrderDetailReqBody;
import com.bookcase.system.bookordermgmt.dto.bookborroworderdetail.BookBorrowOrderDetailReqParam;
import com.bookcase.system.bookordermgmt.otd.bookborroworderdetail.BookBorrowOrderDetailRspBody;
import com.bookcase.system.bookordermgmt.repository.OrderdataBookborrowCarRepository;
import com.bookcase.system.bookordermgmt.repository.OrderdataBookborrowOrderdetailRepository;
import com.bookcase.system.bookordermgmt.service.BookBorrowOrderDetailService;
import com.bookcase.system.bookordermgmt.utils.BookBorrowCarConverter;
import com.bookcase.system.bookordermgmt.utils.BookBorrowOrderDetailConverter;

/**
 * ClassName:BookBorrowOrderDetailServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午7:56:56 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookBorrowOrderDetailServiceImpl implements BookBorrowOrderDetailService{

	@Autowired
	OrderdataBookborrowOrderdetailRepository orderdataBookborrowOrderdetailRepository;
	
	@Override
	public GeneralResult deleteBookBorrowOrderDetails(
			BookBorrowOrderDetailReqParam bookBorrowOrderDetailReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookBorrowOrderDetailReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookBorrowOrderDetailReqParam.getIds()){
			int tmp = orderdataBookborrowOrderdetailRepository.setStatusFor(BookOrderdataMgmtConstant.STATUS_GLOBAL_DELETED, id);
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

	@Override
	public GeneralResult updateBookBorrowOrderDetail(
			String bookBorrowOrderDetailId,
			BookBorrowOrderDetailReqBody bookBorrowOrderDetailReqBody) {
		GeneralResult result = new GeneralResult();
		OrderdataBookborrowOrderdetail tmp = orderdataBookborrowOrderdetailRepository.findBookborrowOrderdetailById(bookBorrowOrderDetailId);
		if(tmp==null){
			result.setCode(BookOrderdataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		OrderdataBookborrowOrderdetail bookborrowOrderdetail = BookBorrowOrderDetailConverter
				.bookBorrowOrderDetailReqBody2OrderdataBookborrowOrderdetail(bookBorrowOrderDetailReqBody);
		bookborrowOrderdetail.setStatus(BookOrderdataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookborrowOrderdetail.setCreator("XXX");
		bookborrowOrderdetail.setId(bookBorrowOrderDetailId);
		bookborrowOrderdetail = orderdataBookborrowOrderdetailRepository
				.save(bookborrowOrderdetail);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	public GeneralContentResult<String> createBookBorrowOrderDetail(
			BookBorrowOrderDetailReqBody bookBorrowOrderDetailReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		OrderdataBookborrowOrderdetail bookborrowOrderdetail = BookBorrowOrderDetailConverter.bookBorrowOrderDetailReqBody2OrderdataBookborrowOrderdetail(bookBorrowOrderDetailReqBody);
		bookborrowOrderdetail.setCreator("XXX");
		bookborrowOrderdetail.setStatus(BookOrderdataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookborrowOrderdetail = orderdataBookborrowOrderdetailRepository.save(bookborrowOrderdetail);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookborrowOrderdetail.getId());
		return result;
	}

	@Override
	public GeneralContentResult<BookBorrowOrderDetailRspBody> findBookBorrowOrderDetailById(
			String bookBorrowOrderDetailId) {
		GeneralContentResult<BookBorrowOrderDetailRspBody> result = new GeneralContentResult<BookBorrowOrderDetailRspBody>();
		OrderdataBookborrowOrderdetail bookborrowOrderdetail  = orderdataBookborrowOrderdetailRepository.findOne(bookBorrowOrderDetailId);
		BookBorrowOrderDetailRspBody rspBody = BookBorrowOrderDetailConverter.bookborrowOrderdetail2BookBorrowOrderDetailRspBody(bookborrowOrderdetail);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	public GeneralPagingResult<List<BookBorrowOrderDetailRspBody>> findBookBorrowOrderDetails(
			String page, String size) {
		GeneralPagingResult<List<BookBorrowOrderDetailRspBody>> result = new GeneralPagingResult<List<BookBorrowOrderDetailRspBody>>();
		List<BookBorrowOrderDetailRspBody> rspBodies = new ArrayList<BookBorrowOrderDetailRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<OrderdataBookborrowOrderdetail> pg = orderdataBookborrowOrderdetailRepository
				.findBookborrowOrderdetails(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (OrderdataBookborrowOrderdetail bookborrowOrderdetail : pg.getContent()) {
				rspBodies.add(BookBorrowOrderDetailConverter
								.bookborrowOrderdetail2BookBorrowOrderDetailRspBody(bookborrowOrderdetail));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

}

