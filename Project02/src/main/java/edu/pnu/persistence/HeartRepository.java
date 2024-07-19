package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.pnu.domain.Heart;

//HeartRepository: Heart 엔티티에 대한 데이터베이스 작업을 처리
public interface HeartRepository extends JpaRepository<Heart, Long> {
	Heart findByUseridAndImgid(String userid, Long imgid);
	
	@Transactional
    void deleteByUseridAndImgid(String userid, Long imgid);

    List<Heart> findByUserid(String userid);
}