package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReviewVO;

public interface ItemReviewMapper {
	public int registerReview(ReviewVO review); // 리뷰 등록
	public int registerReviewImage(@Param("reviewSeq") int reviewSeq,
								   @Param("image") String image,
								   @Param("userId") String userId); // 리뷰 이미지 등록
}
