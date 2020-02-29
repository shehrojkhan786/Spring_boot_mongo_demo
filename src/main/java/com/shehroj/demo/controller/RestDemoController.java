/**
 * 
 */
package com.shehroj.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shehroj.demo.model.Response;
import com.shehroj.demo.model.TODOModel;
import com.shehroj.demo.services.TODOInterface;

/**
 * @author shkhan
 *
 */
@RestController("/")
public class RestDemoController {
	
	@Autowired
	TODOInterface todoService;
	
	@GetMapping(path = {"/","home"})
	@ResponseBody
	public Response home() {
		List<TODOModel> todoModels = todoService.findAll();
		Response response = prepareResponse(todoModels);
		return new Response();
	}

	@PostMapping(path = "create")
	@ResponseBody
	public Response create(@RequestBody TODOModel todoModel) {
		todoModel = todoService.save(todoModel);
		Response response = prepareResponse(todoModel); 
		return response;
	}
	
	@GetMapping(path = "read/{todoId}")
	@ResponseBody
	public Response read(@PathVariable String todoId) {
		TODOModel todoModel = todoService.findById(todoId).orElse(new TODOModel());
		Response response = prepareResponse(todoModel);
		return response;
	}
	
	@PatchMapping(path = "update")
	@ResponseBody
	public Response update(@RequestBody TODOModel todoModel) {
		todoModel = todoService.save(todoModel);
		Response response = prepareResponse(todoModel);
		return response;
	}
	
	@DeleteMapping(path = "delete/{todoId}")
	@ResponseBody
	public Response delete(@PathVariable String todoId) {
		TODOModel todoModel = todoService.findById(todoId).orElse(new TODOModel());
		if(null != todoModel.getId() && !todoModel.getId().isEmpty()) {
			todoService.delete(todoModel);
		}
		boolean isDeleted = todoService.findById(todoId).isPresent();
		Response response = prepareResponse(!isDeleted);
		return response;
	}

	/**
	 * @param todoModelData
	 * @return
	 */
	private Response prepareResponse(List<TODOModel> todoModelData) {
		Response response = new Response();
		response.setResponseCode(HttpStatus.OK.value());
		if(null != todoModelData && !todoModelData.isEmpty()) {
			response.setResponseMesage("Data Found!!!");
			response.setData(todoModelData);
			response.setResponseType("SUCCESS");
		}else {
			response.setResponseMesage("Data Not Found!!!");
			response.setResponseType("FAILURE");
		}
		return response;
	}
	
	/**
	 * @param todoModelData
	 * @return
	 */
	private Response prepareResponse(TODOModel todoModel) {
		Response response = new Response();
		response.setResponseCode(HttpStatus.OK.value());
		if(null != todoModel) {
			response.setResponseMesage("Data Found!!!");
			response.setTodoModel(todoModel);
			response.setResponseType("SUCCESS");
		}else {
			response.setResponseMesage("Data Not Found!!!");
			response.setResponseType("FAILURE");
		}
		return response;
	}
	
	/**
	 * @param todoModelData
	 * @return
	 */
	private Response prepareResponse(boolean isDeleted) {
		Response response = new Response();
		response.setResponseCode(HttpStatus.OK.value());
		if(isDeleted) {
			response.setResponseMesage("Data deleted successfully!!!");
			response.setResponseType("SUCCESS");
		}else {
			response.setResponseMesage("Failure while deleting Data!!!");
			response.setResponseType("FAILURE");
		}
		return response;
	}

	

}
