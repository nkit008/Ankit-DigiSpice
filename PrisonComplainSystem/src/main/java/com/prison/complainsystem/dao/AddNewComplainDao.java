package com.prison.complainsystem.dao;

import com.prison.complainsystem.model.ConnectivityComplainModel;
import com.prison.complainsystem.model.HardwareComplainModel;
import com.prison.complainsystem.model.PhysicalDamageModel;
import com.prison.complainsystem.model.SoftwareComplainModel;

public interface AddNewComplainDao {

	public int addNewHwComplain(HardwareComplainModel newHw);
	public int addNewSwComplain(SoftwareComplainModel newSw);
	public int addNewPhysicalDamageComplain(PhysicalDamageModel newPd);
	public int addNewConnectivityComplain(ConnectivityComplainModel newCm);
}
