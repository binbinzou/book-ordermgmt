package com.bookcase.system.bookordermgmt.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;


/**
 * The persistent class for the orderdata_bookborrow_orderdetail database table.
 * 
 */
@Entity
@Table(name="orderdata_bookborrow_orderdetail")
@NamedQuery(name="OrderdataBookborrowOrderdetail.findAll", query="SELECT o FROM OrderdataBookborrowOrderdetail o")
public class OrderdataBookborrowOrderdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="BOOKBORROW_ORDERID")
	private String bookborrowOrderid;

	@Column(name="BOOKCASE_FROMID")
	private String bookcaseFromid;

	@Column(name="BOOKCASE_TOID")
	private String bookcaseToid;

	@Column(name="BOOKMSG_ID")
	private String bookmsgId;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	@Column(name="CREATOR")
	private String creator;

	@Column(name="STATUS")
	private short status;

	@Column(name="UPDATE_TIME",insertable=false)
	private Timestamp updateTime;

	public OrderdataBookborrowOrderdetail() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookborrowOrderid() {
		return this.bookborrowOrderid;
	}

	public void setBookborrowOrderid(String bookborrowOrderid) {
		this.bookborrowOrderid = bookborrowOrderid;
	}

	public String getBookcaseFromid() {
		return this.bookcaseFromid;
	}

	public void setBookcaseFromid(String bookcaseFromid) {
		this.bookcaseFromid = bookcaseFromid;
	}

	public String getBookcaseToid() {
		return this.bookcaseToid;
	}

	public void setBookcaseToid(String bookcaseToid) {
		this.bookcaseToid = bookcaseToid;
	}

	public String getBookmsgId() {
		return this.bookmsgId;
	}

	public void setBookmsgId(String bookmsgId) {
		this.bookmsgId = bookmsgId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}