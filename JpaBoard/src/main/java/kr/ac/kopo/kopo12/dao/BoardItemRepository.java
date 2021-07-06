package kr.ac.kopo.kopo12.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo12.domain.BoardItem;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Integer>{
	
	BoardItem findAllByIdOrParentId(int id);	//selectOne
	List<BoardItem> findAll(int boardId);	//selectall
	void deleteById(int id);	//delete
	void update(BoardItem boardItem);	//update
	List<BoardItem> findAllByBoardId(int id);
}
