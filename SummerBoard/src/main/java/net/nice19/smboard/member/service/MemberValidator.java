package net.nice19.smboard.member.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.nice19.smboard.member.model.MemberModel;

public class MemberValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		MemberModel memberModel = (MemberModel) target;
		
		if(memberModel.getUserId() == null || memberModel.getUserId().isBlank()) {
			errors.rejectValue("userId", "required");
			
		}
		if(memberModel.getUserPw() == null || memberModel.getUserPw().isBlank()) {
			errors.rejectValue("userPw", "required");
			
		}
		if(memberModel.getUserName() == null || memberModel.getUserName().isBlank()) {
			errors.rejectValue("userName", "required");
			
		}
	}

}
