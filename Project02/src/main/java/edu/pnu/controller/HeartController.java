package edu.pnu.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.pnu.domain.Heart;
import edu.pnu.service.HeartService;

//HeartController: API 요청을 처리하는 컨트롤러

@RestController
@RequestMapping("/api/heart")
public class HeartController {

    private static final Logger logger = LoggerFactory.getLogger(HeartController.class);

    @Autowired
    private HeartService heartService;

    @PostMapping("/like")
    public ResponseEntity<?> like(@RequestParam String userid, @RequestParam Long imgid) {
        try {
            Heart heart = new Heart();
            heart.setUserid(userid);
            heart.setImgid(imgid);
            logger.info("Received like request: {}", heart);
            Heart savedHeart = heartService.saveHeart(heart);
            return ResponseEntity.ok(savedHeart);
        } catch (Exception e) {
            logger.error("Error saving heart", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving heart: " + e.getMessage());
        }
    }

    @PostMapping("/unlike")
    public ResponseEntity<?> unlike(@RequestParam String userid, @RequestParam Long imgid) {
        try {
            logger.info("Received unlike request: userid={}, imgid={}", userid, imgid);
            heartService.deleteHeart(userid, imgid);
            return ResponseEntity.ok("Heart removed");
        } catch (Exception e) {
            logger.error("Error removing heart", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            		.body("Error removing heart: " + e.getMessage());
        }
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Heart>> getHearts(@RequestParam String userid) {
        try {
            List<Heart> hearts = heartService.getHeartsByUserid(userid);
            return ResponseEntity.ok(hearts);
        } catch (Exception e) {
            logger.error("Error fetching hearts", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
}
