package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.GroupRepository;
import com.vti.backend.datalayer.IGroupRepository;
import com.vti.entiy.Group;

public class GroupService implements IGroupService {

	private IGroupRepository iGroupRepository;

	public GroupService() {
		iGroupRepository = new GroupRepository();
	}

	public List<Group> getListGroups() throws ClassNotFoundException,
			SQLException {
		// logic service
		return iGroupRepository.getListGroups();
	}
}