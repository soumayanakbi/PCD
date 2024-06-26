package com.trainTruck.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainTruck.demo.Model.Route;

@Repository
public interface RouteRepo extends JpaRepository<Route, Integer> {
	public List<Route> findByAgancy(int id);
	public Route findByRouteLongName(String routeLongName);
}
