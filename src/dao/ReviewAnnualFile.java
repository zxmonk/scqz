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

/**
 * ReviewAnnualFile entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "REVIEW_ANNUAL_FILE", schema = "ZXM")
public class ReviewAnnualFile implements java.io.Serializable {

	// Fields

	private String fileName;
	private Date dateInsert;
	private Date dateUpdate;
	private Date dataDate;
	private byte[] fileBlob;

	// Constructors

	/** default constructor */
	public ReviewAnnualFile() {
	}

	/** minimal constructor */
	public ReviewAnnualFile(Date dateInsert) {
		this.dateInsert = dateInsert;
	}

	/** full constructor */
	public ReviewAnnualFile(Date dateInsert, Date dateUpdate, Date dataDate,
			byte[] fileBlob) {
		this.dateInsert = dateInsert;
		this.dateUpdate = dateUpdate;
		this.dataDate = dataDate;
		this.fileBlob = fileBlob;
	}

	// Property accessors
	@Id
	//@GeneratedValue
	@Column(name = "FILE_NAME", unique = true, nullable = false, length = 50)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_INSERT", nullable = false, length = 7)
	public Date getDateInsert() {
		return this.dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
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
	@Column(name = "DATA_DATE", length = 7)
	public Date getDataDate() {
		return this.dataDate;
	}

	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}

	@Lob
	@Column(name = "FILE_BLOB")
	public byte[] getFileBlob() {
		return this.fileBlob;
	}

	public void setFileBlob(byte[] fileBlob) {
		this.fileBlob = fileBlob;
	}

}