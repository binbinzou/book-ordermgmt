/**
 * Project Name:book-ordermgmt
 * File Name:OrderdataBookborrowCarRepository.java
 * Package Name:com.bookcase.system.bookordermgmt.repository
 * Date:2017年6月4日下午4:46:49
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookordermgmt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookcase.system.bookordermgmt.constant.BookOrderdataMgmtConstant;
import com.bookcase.system.bookordermgmt.domain.OrderdataBookborrowCar;

/**
 * ClassName:OrderdataBookborrowCarRepository <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午4:46:49 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Repository
public interface OrderdataBookborrowCarRepository extends JpaRepository<OrderdataBookborrowCar, String>{

	@Query("SELECT a FROM OrderdataBookborrowCar a where a.status<" + BookOrderdataMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<OrderdataBookborrowCar> findBookborrowCars(Pageable pageable);

	@Query("SELECT a FROM OrderdataBookborrowCar a where a.id = ?1 AND a.status<" + BookOrderdataMgmtConstant.STATUS_GLOBAL_DELETED)
	OrderdataBookborrowCar findBookBorrowCarById(String bookBorrowCarId);

	@Query("UPDATE OrderdataBookborrowCar a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short statusGlobalDeleted, String id);

}

