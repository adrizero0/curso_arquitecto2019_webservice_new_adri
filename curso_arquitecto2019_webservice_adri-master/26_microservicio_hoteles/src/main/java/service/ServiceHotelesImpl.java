package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoHoteles;
import model.Hotel;

@Service
public class ServiceHotelesImpl implements ServiceHoteles {

	@Autowired
	DaoHoteles hoteles;
	
	@Override
	public List<Hotel> hotelesDisponibles() {
		return hoteles.findAllDisponible();
	}

}
