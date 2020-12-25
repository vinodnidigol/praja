package com.project.news.prajathathva.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.news.prajathathva.pojo.NewsPublish;

@Repository("News")
public interface News extends JpaRepository<NewsPublish, Integer> {
	
	@Query("from NewsPublish order by edate desc")
	 List<NewsPublish> findAll() ;
	

	@Query(value="select * from newspub order by edate desc limit 5" , nativeQuery = true)
	 List<NewsPublish> latest3() ;
	
	
	@Query("from NewsPublish where id=:id")
	List<NewsPublish> findbyid(@Param(value = "id") Integer id);
	
	@Query("from NewsPublish where cat=:category order by edate desc")
	List<NewsPublish> selectbycat(@Param(value="category") String cat);
	
	@Query(value="select * from newspub where cat=:category order by edate desc limit :limit", nativeQuery=true)
	List<NewsPublish> selectby5(@Param(value="category")String cat ,
			@Param(value="limit")int limit);
}
