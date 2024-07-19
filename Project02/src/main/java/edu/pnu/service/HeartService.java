package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pnu.domain.Heart;
import edu.pnu.domain.User;
import edu.pnu.persistence.HeartRepository;
import edu.pnu.persistence.UserRepository;

//HeartService: 비즈니스 로직을 처리하는 서비스

@Service
public class HeartService {

    @Autowired
    private HeartRepository heartRepository;

    @Transactional
    public Heart saveHeart(Heart heart) {
        // 예외가 발생할 수 있는 코드
        try {
            return heartRepository.save(heart);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save heart", e);
        }
    }

    @Transactional
    public void deleteHeart(String userid, Long imgid) {
        // 예외가 발생할 수 있는 코드
        try {
            heartRepository.deleteByUseridAndImgid(userid, imgid);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete heart", e);
        }
    }
    
    public List<Heart> getHeartsByUserid(String userid) {
        return heartRepository.findByUserid(userid);
    }
}