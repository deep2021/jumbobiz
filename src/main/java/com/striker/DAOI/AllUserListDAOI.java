package com.striker.DAOI;

import java.util.List;

import com.striker.DTO.UsersListDTO;

public interface AllUserListDAOI {

	// list method for getting all users list
	public List<UsersListDTO> allUser();
	public List<UsersListDTO> allSuppliers();
	public int deleteSupplier(int id);
	public int deleteUser(int id);
	public boolean makeSupplier(int id);
}