package com.edubridge.VacuumCleaner.Services;

import java.util.List;

import com.edubridge.VacuumCleaner.Dao.VacuumCleanerDaoImpl;
import com.edubridge.VacuumCleaner.model.VacuumCleaner;

public class VacuumCleanerServicesImpl implements VacuumCleanerServices {

		private VacuumCleanerDaoImpl dao = new VacuumCleanerDaoImpl();

		@Override
		public int addVacuumCleaner(VacuumCleaner vc) {
			
			return dao.addVacuumCleaner(vc);
		}

		@Override
		public List<VacuumCleaner> findVacuumCleaner() {
			// TODO Auto-generated method stub
			return dao.findVacuumCleaner();
		}

		@Override
		public VacuumCleaner findVacuumCleanerByBrand(String brand) {
			// TODO Auto-generated method stub
			return dao.findVacuumCleanerByBrand(brand);
		}

		@Override
		public int updateVacuumCleaner(VacuumCleaner vc) {
			// TODO Auto-generated method stub
			return dao.addVacuumCleaner(vc);
		}

		@Override
		public int deleteVacuumCleanerByBrand(String brand) {
			// TODO Auto-generated method stub
			return dao.deleteVacuumCleanerByBrand(brand);
		}

		@Override
		public void deleteAllVacuumCleaners() {
			// TODO Auto-generated method stub
			
		}

	
}
