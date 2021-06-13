package kodlama.hrms.core.utilities.fakeMernisAdapter;

import org.springframework.stereotype.Service;

import kodlama.hrms.fakeMernis.Mernis;

@Service
public class FakeMernisAdapter implements FakeMernisService  {

	
	
	@Override
	public void mernisCheck(String email) {
		Mernis mernis = new Mernis();
		mernis.mernisCheck(email);
		
	}

	
	

	
	

}
