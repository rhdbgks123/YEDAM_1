package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.ItemReviewMapper;
import com.yedam.vo.ReviewVO;

public class ItemReviewServiceImpl implements ItemReviewService{
	
	SqlSession sqlSession = DBUtil.getInstance().openSession();
	ItemReviewMapper mapper = sqlSession.getMapper(ItemReviewMapper.class);
	
	@Override
	public boolean writeReview(ReviewVO review) {
		int r = mapper.registerReview(review);
		if(r > 0 && review.getImages() != null) {
			for(String img : review.getImages()) {
				mapper.registerReviewImage(review.getReviewSeq(), img, review.getUserId());
			}
			sqlSession.commit();
			return true;
		}
		return false;
	}

	
	
}
