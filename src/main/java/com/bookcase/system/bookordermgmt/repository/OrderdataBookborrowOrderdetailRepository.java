/**
 * Project Name:book-ordermgmt
 * File Name:OrderdataBookborrowOrderdetailRepository.java
 * Package Name:com.bookcase.system.bookordermgmt.repository
 * Date:2017年6月4日下午4:48:52
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookcase.system.bookordermgmt.constant.BookOrderdataMgmtConstant;
import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowCar;
import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowOrderdetail;

/**
 * ClassName:OrderdataBookborrowOrderdetailRepository <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午4:48:52 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface OrderdataBookborrowOrderdetailRepository extends JpaRepository<OrderdataBookborrowOrderdetail, String>{

	@Query("SELECT a FROM OrderdataBookborrowOrderdetail a where a.status<" + BookOrderdataMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<OrderdataBookborrowOrderdetail> findBookborrowOrderdetails(
			Pageable pageable);

	@Query("SELECT a FROM OrderdataBookborrowOrderdetail a where a.id = ?1 AND a.status<" + BookOrderdataMgmtConstant.STATUS_GLOBAL_DELETED)
	OrderdataBookborrowOrderdetail findBookborrowOrderdetailById(
			String bookBorrowOrderDetailId);

	@Query("UPDATE OrderdataBookborrowOrderdetail a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short statusGlobalDeleted, String id);

}

