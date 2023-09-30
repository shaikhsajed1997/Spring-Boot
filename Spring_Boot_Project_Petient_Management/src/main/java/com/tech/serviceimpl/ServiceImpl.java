package com.tech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.model.Patient;
import com.tech.repository.HospitalRepository;
import com.tech.servicei.ServiceI;

@Service
public class ServiceImpl implements ServiceI {

	@Autowired
	HospitalRepository hrp;

	@Override
	public String addPatient(Patient p) {
		Optional<Patient> id = hrp.findById(p.getP_Id());
		if (id.isPresent() == false) {
			Patient patient = hrp.save(p);
			String p_Id = patient.getP_Id();
			return "Patient id " + p_Id + " is added successfully";
		} else {

			return "This patient id " + p.getP_Id() + " is already available";
		}
	}

	@Override
	public String addPatients(List<Patient> p) {

		hrp.saveAll(p);

		return "Data Saved Successfully";
	}

	@Override
	public Optional<Patient> getPatient(String pid) {
		Optional<Patient> p = hrp.findById(pid);

		return p;
	}

	@Override
	public String deletePatient(String pid) {

		Optional<Patient> p = hrp.findById(pid);
		if (p.isPresent()) {
			hrp.deleteById(pid);
			return "Patient id " + pid + " data is delete successfully";
		} else {

			return "Patient id " + pid + " is not found";
		}

	}

	@Override
	public String updatePatient(Patient p) {

		Optional<Patient> id = hrp.findById(p.getP_Id());
		if (id.isPresent()) {
			Patient patient = hrp.save(p);

			return "Patient id " + patient.getP_Id() + " is update successfully";
		} else {
			return "Patient record is not found ";
		}
	}

}
