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
 * ReportMonthly entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "REPORT_MONTHLY", schema = "ZXM", uniqueConstraints = @UniqueConstraint(columnNames = "RM_ID"))
public class ReportMonthly implements java.io.Serializable {

	// Fields

	private String rmFilename;
	private Integer rmId;
	private Date dateEntered;
	private Date dateUpdate;
	private Date dateDate;
	private byte[] rmFile;
	private String rmStationid;
	private String submitter;
	private String rmStationname;

	// Constructors

	/** default constructor */
	public ReportMonthly() {
	}

	/** minimal constructor */
	public ReportMonthly(Date dateEntered) {
		this.dateEntered = dateEntered;
	}

	/** full constructor */
	public ReportMonthly(Integer rmId, Date dateEntered, Date dateUpdate,
			Date dateDate, byte[] rmFile, String rmStationid, String submitter,
			String rmStationname) {
		this.rmId = rmId;
		this.dateEntered = dateEntered;
		this.dateUpdate = dateUpdate;
		this.dateDate = dateDate;
		this.rmFile = rmFile;
		this.rmStationid = rmStationid;
		this.submitter = submitter;
		this.rmStationname = rmStationname;
	}

	// Property accessors
	@Id
	
	@Column(name = "RM_FILENAME", unique = true, nullable = false, length = 50)
	public String getRmFilename() {
		return this.rmFilename;
	}

	public void setRmFilename(String rmFilename) {
		this.rmFilename = rmFilename;
	}

	@Column(name = "RM_ID", unique = true, precision = 7, scale = 0)
	public Integer getRmId() {
		return this.rmId;
	}

	public void setRmId(Integer rmId) {
		this.rmId = rmId;
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
	@Column(name = "RM_FILE")
	public byte[] getRmFile() {
		return this.rmFile;
	}

	public void setRmFile(byte[] rmFile) {
		this.rmFile = rmFile;
	}

	@Column(name = "RM_STATIONID", length = 50)
	public String getRmStationid() {
		return this.rmStationid;
	}

	public void setRmStationid(String rmStationid) {
		this.rmStationid = rmStationid;
	}

	@Column(name = "SUBMITTER", length = 50)
	public String getSubmitter() {
		return this.submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	@Column(name = "RM_STATIONNAME", length = 50)
	public String getRmStationname() {
		return this.rmStationname;
	}

	public void setRmStationname(String rmStationname) {
		this.rmStationname = rmStationname;
	}

}