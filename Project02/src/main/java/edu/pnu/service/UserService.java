package edu.pnu.service;

import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pnu.domain.User;
import edu.pnu.dto.AddUserRequest;
import edu.pnu.dto.LoginResponse;
import edu.pnu.persistence.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Optional<User> findByUserid(String userid) {
        return userRepository.findByUserid(userid);
    }
	
	
	@Transactional
	public Long save(AddUserRequest request) throws DuplicateKeyException {
		// 비밀번호를 BCryptPasswordEncoder를 사용하여 암호화
        String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());

     // 이미 존재하는 userid인지 확인
        if (userRepository.existsByUserid(request.getUserid())) {
            throw new DuplicateKeyException("이미 존재하는 사용자 userid입니다.");
        }
        
     // User 엔티티를 생성하고 저장
        User user = User.builder()
                .userid(request.getUserid())
                .username(request.getUsername()) // 추가적으로 유저네임 추가
                .password(encodedPassword)
                .build();

        User savedUser = userRepository.save(user);
        return savedUser.getIdx();
    }
	
}







