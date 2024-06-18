package com.edubridge.VacuumCleaner.Services;

import java.util.List;

import com.edubridge.VacuumCleaner.model.VacuumCleaner;

public interface VacuumCleanerServices {

		int addVacuumCleaner(VacuumCleaner vc);
		List<VacuumCleaner> findVacuumCleaner();
		VacuumCleaner findVacuumCleanerByBrand(String brand);
		int updateVacuumCleaner(VacuumCleaner vc);
		int deleteVacuumCleanerByBrand(String brand);
		void deleteAllVacuumCleaners();
	}