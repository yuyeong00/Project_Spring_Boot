package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.domain.User;
import edu.pnu.persistence.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    // 사용자 이름(userid)으로 사용자 정보를 가져오는 메소드
    @Override
    public User loadUserByUsername(String userid) throws UsernameNotFoundException {
        return userRepository.findByUserid(userid)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with userid: " + userid));
    }
}
