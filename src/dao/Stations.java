package dao;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Stations entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "STATIONS", schema = "ZXM")
public class Stations implements java.io.Serializable {

	// Fields

	private BigDecimal stationid;
	private String staionname;

	// Constructors

	/** default constructor */
	public Stations() {
	}

	/** full constructor */
	public Stations(String staionname) {
		this.staionname = staionname;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "STATIONID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getStationid() {
		return this.stationid;
	}

	public void setStationid(BigDecimal stationid) {
		this.stationid = stationid;
	}

	@Column(name = "STAIONNAME", length = 50)
	public String getStaionname() {
		return this.staionname;
	}

	public void setStaionname(String staionname) {
		this.staionname = staionname;
	}

}