package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.MemberDAO;
import dto.MemberDTO;

public class TopJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		
		List<MemberDTO> list = MemberDAO.getInstance().selectTop();
		
		// LIST를 파일로 만들기
		File file = new File("top.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {	// try - catch resource 의 특징 try()안에 사용할 resource를 지정하여 진행되고난 뒤, 자동으로 종료하여, close를 따로 해주지 않아도 됨.
			for (MemberDTO memberDTO : list) {
				bw.write("회원번호: " + memberDTO.getNo() + ",");
				bw.write("회원아이디: " + memberDTO.getId() + ",");
				bw.write("회원명: " + memberDTO.getName() + ",");
				bw.write("회원등급: " + memberDTO.getGrade() + ",");
				bw.write("회원포인트: " + memberDTO.getPoint() + "\n");
			}
			System.out.println("top.txt 파일 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
