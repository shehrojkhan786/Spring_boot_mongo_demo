/**
 * 
 */
package com.shehroj.demo.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shehroj.demo.model.TODOModel;

/**
 * @author shkhan
 *
 */
public interface TODOInterface extends MongoRepository<TODOModel, String>{
	
//	int count();
//
//	int save(T t);
//
//	int update(T t);
//
//	int deleteById(Long id);

	//List<T> findAll();

	
//	default List<T> findByParentId(Long parentId){
//		return null;
//	}
//	
//	Optional<T> findById(Long id);

	//String getNameById(Long id);


}
