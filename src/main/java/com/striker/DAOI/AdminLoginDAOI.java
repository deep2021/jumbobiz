package com.striker.DAOI;

import com.striker.DTO.LoginDTO;
import com.striker.DTO.UsersListDTO;

public interface AdminLoginDAOI {
	public LoginDTO login(LoginDTO dto);
	public UsersListDTO getProfile();
	public int editSaveProfile(UsersListDTO dto);

}
