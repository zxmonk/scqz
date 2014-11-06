package dao;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * ReportYear entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "REPORT_YEAR", schema = "ZXM", uniqueConstraints = @UniqueConstraint(columnNames = "RY_ID"))
public class ReportYear implements java.io.Serializable {

	// Fields

	private String ryFilename;
	private Integer ryId;
	private Date dateEntered;
	private Date dateUpdate;
	private Date dateDate;
	private byte[] ryFile;
	private String ryStationid;
	private String ryStationname;
	private String submitter;

	// Constructors

	/** default constructor */
	public ReportYear() {
	}

	/** minimal constructor */
	public ReportYear(Date dateEntered) {
		this.dateEntered = dateEntered;
	}

	/** full constructor */
	public ReportYear(Integer ryId, Date dateEntered, Date dateUpdate,
			Date dateDate, byte[] ryFile, String ryStationid,
			String ryStationname, String submitter) {
		this.ryId = ryId;
		this.dateEntered = dateEntered;
		this.dateUpdate = dateUpdate;
		this.dateDate = dateDate;
		this.ryFile = ryFile;
		this.ryStationid = ryStationid;
		this.ryStationname = ryStationname;
		this.submitter = submitter;
	}

	// Property accessors
	@Id
	
	@Column(name = "RY_FILENAME", unique = true, nullable = false, length = 50)
	public String getRyFilename() {
		return this.ryFilename;
	}

	public void setRyFilename(String ryFilename) {
		this.ryFilename = ryFilename;
	}

	@Column(name = "RY_ID", unique = true, precision = 7, scale = 0)
	public Integer getRyId() {
		return this.ryId;
	}

	public void setRyId(Integer ryId) {
		this.ryId = ryId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ENTERED", nullable = false, length = 7)
	public Date getDateEntered() {
		return this.dateEntered;
	}

	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_UPDATE", length = 7)
	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_DATE", length = 7)
	public Date getDateDate() {
		return this.dateDate;
	}

	public void setDateDate(Date dateDate) {
		this.dateDate = dateDate;
	}

	@Lob
	@Column(name = "RY_FILE")
	public byte[] getRyFile() {
		return this.ryFile;
	}

	public void setRyFile(byte[] ryFile) {
		this.ryFile = ryFile;
	}

	@Column(name = "RY_STATIONID", length = 50)
	public String getRyStationid() {
		return this.ryStationid;
	}

	public void setRyStationid(String ryStationid) {
		this.ryStationid = ryStationid;
	}

	@Column(name = "RY_STATIONNAME", length = 50)
	public String getRyStationname() {
		return this.ryStationname;
	}

	public void setRyStationname(String ryStationname) {
		this.ryStationname = ryStationname;
	}

	@Column(name = "SUBMITTER", length = 50)
	public String getSubmitter() {
		return this.submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

}