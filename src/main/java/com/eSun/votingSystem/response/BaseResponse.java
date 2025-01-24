package com.eSun.votingSystem.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eSun.votingSystem.dao.BaseDao;
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
	public static final String STATUS_MSG_QUERY_FAILURE = "查詢失敗!";
	// Response Message - INSERT
	public static final String STATUS_MSG_CREATE_SUCCESS = "新增成功！";
	public static final String STATUS_MSG_CREATE_FAILURE = "新增失敗！";
	public static final String STATUS_MSG_DATA_DUPLICATED = "資料已存在。";
	// Response Message - Update
	
	public BaseResponse() {
		super();
	}
	
	public BaseResponse(BaseDao content) {
		super();
		if (content == null) {
			this.content = new BaseDao();
			
		} else {
			this.content = content;
		}
	}
	
	public BaseResponse(List<? extends BaseDao> contents) {
		super();
		this.contents = contents;
	}
	
	// Response Content
	@JsonProperty("content")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private BaseDao content = null;

	@JsonProperty("contents")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<? extends BaseDao> contents = null;
	
	@JsonProperty("result_type")
	private String result_type = "";
	
	@JsonProperty("result_msg")
	private String result_msg = "";

}
