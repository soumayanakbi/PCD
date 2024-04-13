package com.trainTruck.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="stop_times")
public class StopTimes {
	@Id
	private int stopTimesId=0;
	
	
	@JsonIgnoreProperties({"stopsTime","route_id"})
	@ManyToOne
	@JoinColumn(name = "trip_id")
	private Trip trip_id;
	
	private String arrival_time;
	private String departure_time;
	
	@JsonIgnoreProperties("stopsTime")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "stop_id")
	private Stop stop_id;
	
	private int stop_sequence;
	private String stop_headsign;
	private int pickup_type;
	private int drop_off_type;
	private int shape_dist_traveled;
}
