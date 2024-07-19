package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Heart 엔티티: 데이터베이스에 저장되는 하트 데이터를 나타냄
@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Heart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx; // 기본 키
	private String userid; // 사용자 아이디
	private Long imgid; // 이미지 아이디
	
	public Heart() {
    }
}