package kodlama.hrms.core.utilities.fakeMernisAdapter;

import kodlama.hrms.fakeMernis.Mernis;

public class FakeMernisAdapter implements FakeMernisService  {

	
	
	@Override
	public void mernisCheck(String email) {
		Mernis mernis = new Mernis();
		mernis.mernisCheck(email);
		
	}

	
	

	
	

}
