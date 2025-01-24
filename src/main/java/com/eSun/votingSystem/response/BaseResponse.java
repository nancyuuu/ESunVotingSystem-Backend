package com.eSun.votingSystem.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class BaseResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Response type
	public static final String STATUS_TYPE_SUCCESS = "success";
	public static final String STATUS_TYPE_FAILURE = "failure";
	// Response Message - QUERY
	public static final String STATUS_MSG_QUERY_SUCCESS = "查詢成功!";
	public static final String STATUS_MSG_QUERY_EMPTY = "查無資料！";
	public static final String STATUS_MSG_QUERY_FAILURE = "查詢失敗!";
	// Response Message - INSERT
	public static final String STATUS_MSG_CREATE_SUCCESS = "新增成功！";
	public static final String STATUS_MSG_CREATE_FAILURE = "新增失敗！";
	public static final String STATUS_MSG_CREATE_DUPLICATED = "資料已存在。";
	// Response Message - UPDATE
	public static final String STATUS_MSG_UPDATE_SUCCESS = "更新成功！";
	public static final String STATUS_MSG_UPDATE_FAILURE = "更新失敗！";
	// Response Message - DELETE
	public static final String STATUS_MSG_DELETE_SUCCESS = "刪除成功！";
	public static final String STATUS_MSG_DELETE_EMPTY = "查無資料！";
	public static final String STATUS_MSG_DELETE_FAILURE = "刪除失敗！";
	
	public BaseResponse() {
		super();
	}
	
	public BaseResponse(Object content) {
		super();
		this.content = content;
	}
	
	public BaseResponse(List<? extends Object> contents) {
		super();
		this.contents = contents;
	}
	
	// Response Content
	@JsonProperty("content")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object content = null;

	@JsonProperty("contents")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<? extends Object> contents = null;
	
	@JsonProperty("result_type")
	private String result_type = "";
	
	@JsonProperty("result_msg")
	private String result_msg = "";

}
