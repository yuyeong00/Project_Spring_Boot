package edu.pnu.persistence;

import edu.pnu.domain.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//UserRepository: User 엔티티에 대한 데이터베이스 작업을 처리
public interface UserRepository extends JpaRepository<User, Long> {
	// userid로 사용자 정보를 가져옴
    Optional<User> findByUserid(String userid);
    
    // 회원가입 중복 userid 확인
    boolean existsByUserid(String userid);
}