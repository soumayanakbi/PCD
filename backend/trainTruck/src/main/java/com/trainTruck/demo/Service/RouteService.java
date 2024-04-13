package com.trainTruck.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainTruck.demo.Model.Route;
import com.trainTruck.demo.Repository.RouteRepo;

@Service
public class RouteService {
	@Autowired 
	RouteRepo routeRepo ;
	
	public List<Route> findRoutes() {
		return routeRepo.findAll();
	}
	public List<Route> findRoutesByAgencyId(int id) {
		return routeRepo.findByAgancy(id);
	}
}
