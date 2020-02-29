/**
 * 
 */
package com.shehroj.demo.model;

import java.util.List;

/**
 * @author shkhan
 *
 */
public class Response {
	
	private List<TODOModel> data;
	private TODOModel todoModel;
	private String responseType;
	private int responseCode;
	private String responseMesage;
	/**
	 * @return the data
	 */
	public List<TODOModel> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<TODOModel> todoModel) {
		this.data = todoModel;
	}
	/**
	 * @return the responseType
	 */
	public String getResponseType() {
		return responseType;
	}
	/**
	 * @param responseType the responseType to set
	 */
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	/**
	 * @return the responseCode
	 */
	public int getResponseCode() {
		return responseCode;
	}
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	/**
	 * @return the responseMesage
	 */
	public String getResponseMesage() {
		return responseMesage;
	}
	/**
	 * @param responseMesage the responseMesage to set
	 */
	public void setResponseMesage(String responseMesage) {
		this.responseMesage = responseMesage;
	}
	/**
	 * @return the todoModel
	 */
	public TODOModel getTodoModel() {
		return todoModel;
	}
	/**
	 * @param todoModel the todoModel to set
	 */
	public void setTodoModel(TODOModel todoModel) {
		this.todoModel = todoModel;
	}

}
