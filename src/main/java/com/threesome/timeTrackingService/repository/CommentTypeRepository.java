package com.threesome.timeTrackingService.repository;


import com.threesome.timeTrackingService.model.CommentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentTypeRepository extends CrudRepository<CommentType, Integer> {
}
