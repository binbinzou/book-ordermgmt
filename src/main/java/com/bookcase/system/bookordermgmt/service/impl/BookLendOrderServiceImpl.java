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
import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowOrder;
import com.bookcase.system.bookordermgmt.domain.OrderdataBooklendOrder;
import com.bookcase.system.bookordermgmt.dto.booklendorder.BookLendOrderReqBody;
import com.bookcase.system.bookordermgmt.dto.booklendorder.BookLendOrderReqParam;
import com.bookcase.system.bookordermgmt.otd.booklendorder.BookLendOrderRspBody;
import com.bookcase.system.bookordermgmt.repository.OrderdataBooklendOrderRepository;
import com.bookcase.system.bookordermgmt.service.BookLendOrderService;
import com.bookcase.system.bookordermgmt.utils.BookBorrowOrderConverter;
import com.bookcase.system.bookordermgmt.utils.BookLendOrderConverter;

@Service
@Slf4j
public class BookLendOrderServiceImpl implements BookLendOrderService {

	@Autowired
	OrderdataBooklendOrderRepository orderdataBooklendOrderRepository;
	
	@Override
	public GeneralPagingResult<List<BookLendOrderRspBody>> findBookLendOrders(
			String page, String size) {
		GeneralPagingResult<List<BookLendOrderRspBody>> result = new GeneralPagingResult<List<BookLendOrderRspBody>>();
		List<BookLendOrderRspBody> rspBodies = new ArrayList<BookLendOrderRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<OrderdataBooklendOrder> pg = orderdataBooklendOrderRepository
				.findBookLendOrders(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (OrderdataBooklendOrder booklendOrder : pg.getContent()) {
				rspBodies.add(BookLendOrderConverter
								.booklendOrder2BookLendOrderRspBody(booklendOrder));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookLendOrderRspBody> findBookLendOrderById(
			String bookLendOrderId) {
		GeneralContentResult<BookLendOrderRspBody> result = new GeneralContentResult<BookLendOrderRspBody>();
		OrderdataBooklendOrder booklendOrder  = orderdataBooklendOrderRepository.findOne(bookLendOrderId);
		BookLendOrderRspBody rspBody = BookLendOrderConverter.booklendOrder2BookLendOrderRspBody(booklendOrder);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookLendOrder(
			BookLendOrderReqBody bookLendOrderReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		OrderdataBooklendOrder booklendOrder = BookLendOrderConverter.bookLendOrderReqBody2OrderdataBooklendOrder(bookLendOrderReqBody);
		booklendOrder.setCreator("XXX");
		booklendOrder.setStatus(BookOrderdataMgmtConstant.STATUS_GLOBAL_ENABLE);
		booklendOrder = orderdataBooklendOrderRepository.save(booklendOrder);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(booklendOrder.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookLendOrder(String bookLendOrderId,
			BookLendOrderReqBody bookLendOrderReqBody) {
		GeneralResult result = new GeneralResult();
		OrderdataBooklendOrder tmp = orderdataBooklendOrderRepository.findBookLendOrderById(bookLendOrderId);
		if(tmp==null){
			result.setCode(BookOrderdataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		OrderdataBooklendOrder booklendOrder = BookLendOrderConverter
				.bookLendOrderReqBody2OrderdataBooklendOrder(bookLendOrderReqBody);
		booklendOrder.setStatus(BookOrderdataMgmtConstant.STATUS_GLOBAL_ENABLE);
		booklendOrder.setCreator("XXX");
		booklendOrder.setId(bookLendOrderId);
		booklendOrder = orderdataBooklendOrderRepository
				.save(booklendOrder);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookLendOrders(
			BookLendOrderReqParam bookLendOrderReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookLendOrderReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookLendOrderReqParam.getIds()){
			int tmp = orderdataBooklendOrderRepository.setStatusFor(BookOrderdataMgmtConstant.STATUS_GLOBAL_DELETED, id);
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
