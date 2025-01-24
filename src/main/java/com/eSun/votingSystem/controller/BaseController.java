package com.eSun.votingSystem.controller;

import com.eSun.votingSystem.components.DeleteResult;
import com.eSun.votingSystem.components.InsertResult;
import com.eSun.votingSystem.components.QueryResult;
import com.eSun.votingSystem.components.UpdateResult;
import com.eSun.votingSystem.response.BaseResponse;

public class BaseController {
	public <T extends BaseResponse> T setQueryResponse(T returnBody, QueryResult resultType) {
		switch (resultType) {
		case SUCCESS:
			// 資料查詢成功
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_SUCCESS);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_QUERY_SUCCESS);
			break;
			
		case EMPTY:
			// 查無資料
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_SUCCESS);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_QUERY_EMPTY);
			
		case FAILURE:
			// 資料查詢失敗
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_FAILURE);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_QUERY_FAILURE);
			break;
		}
		return returnBody;
	}
	
	public <T extends BaseResponse> T setInsertResponse(T returnBody, InsertResult resultType) {
		switch (resultType) {
		case SUCCESS:
			// 資料新增成功
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_SUCCESS);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_CREATE_SUCCESS);
			break;
			
		case FAILURE:
			// 資料新增失敗
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_FAILURE);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_CREATE_FAILURE);
			break;
			
		case DUPLICATE:
			// 資料重複
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_FAILURE);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_CREATE_DUPLICATED);
			break;
			
		}
		return returnBody;
	}
	
	public <T extends BaseResponse> T setUpdateResponse(T returnBody, UpdateResult resultType) {
		switch (resultType) {
		case SUCCESS:
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_SUCCESS);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_UPDATE_SUCCESS);
			break;
			
		case FAILURE:
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_FAILURE);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_UPDATE_FAILURE);
			break;
		}
		return returnBody;
	}
	
	public <T extends BaseResponse> T setDeleteResponse(T returnBody, DeleteResult resultType) {
		switch (resultType) {
		case SUCCESS:
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_SUCCESS);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_DELETE_SUCCESS);
			break;
			
		case EMPTY:
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_SUCCESS);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_DELETE_EMPTY);
			break;
			
		case FAILURE:
			returnBody.setResult_type(BaseResponse.STATUS_TYPE_FAILURE);
			returnBody.setResult_msg(BaseResponse.STATUS_MSG_DELETE_FAILURE);
			
			break;
		}
		return returnBody;
	}
}
