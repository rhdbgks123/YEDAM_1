package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;

// BoardService 인터페이스 구현 클래스
// 인터페이스에 정의된 추상메소드를 반드시 구현
public class _FOREXAMPLEIMPL implements _FOREXAMPLE{

	SqlSession session = DBUtil.getInstance().openSession();
//	BoardMapper mapper = session.getMapper(BoardMapper.class);
//	
//	
//	@Override
//	public List<BoardVO> boardList(SearchDTO search) {
//		// TODO 자동 생성된 메소드 스텁
//		return mapper.selectList(search);
//	}
//
//	@Override
//	public BoardVO searchBoard(int boardNo) {
//		// TODO 자동 생성된 메소드 스텁
//		BoardVO board = mapper.selectBoard(boardNo); // 조회
//		int r = mapper.updateCount(boardNo); // 카운터증가
//		if(r > 0)
//			session.commit();
//		return board;
//	}
//
//	@Override
//	public boolean registerBoard(BoardVO board) {
//		int r = mapper.insertBoard(board);
//		if (r> 0)
//		{
//			session.commit();
//			return true;
//		}
//		
//		return false;
//	}
//
//	@Override
//	public boolean removeBoard(int boardNo) {
//		
//		int r = mapper.deleteBoard(boardNo);
//		if(r > 0)
//		{
//			session.commit();
//			return true;
//		}
//		
//		return false;
//	}
//
//	@Override
//	public int totalCount(SearchDTO search)
//	{
//		return mapper.selectCnt(search);
//	}
//
//	@Override
//	public boolean modifyBoard(BoardVO board)
//	{
//		int r = mapper.updateBoard(board);
//		if (r> 0)
//		{
//			session.commit();
//			return true;
//		}
//		return false;
//	}
	
}
