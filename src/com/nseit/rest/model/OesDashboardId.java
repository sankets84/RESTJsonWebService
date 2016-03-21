package com.nseit.rest.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OesDashboardId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class OesDashboardId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2808273719970228005L;
	private Long odTcId;
	private Date odTestDate;
	private String odBatch;

	// Constructors

	/** default constructor */
	public OesDashboardId() {
	}

	/** full constructor */
	public OesDashboardId(Long odTcId, Date odTestDate, String odBatch) {
		this.odTcId = odTcId;
		this.odTestDate = odTestDate;
		this.odBatch = odBatch;
	}

	// Property accessors

	@Column(name = "od_tc_id", nullable = false, precision = 16, scale = 0)
	public Long getOdTcId() {
		return this.odTcId;
	}

	public void setOdTcId(Long odTcId) {
		this.odTcId = odTcId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "od_test_date", nullable = false, length = 13)
	public Date getOdTestDate() {
		return this.odTestDate;
	}

	public void setOdTestDate(Date odTestDate) {
		this.odTestDate = odTestDate;
	}

	@Column(name = "od_batch", nullable = false, length = 11)
	public String getOdBatch() {
		return this.odBatch;
	}

	public void setOdBatch(String odBatch) {
		this.odBatch = odBatch;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OesDashboardId))
			return false;
		OesDashboardId castOther = (OesDashboardId) other;

		return ((this.getOdTcId() == castOther.getOdTcId()) || (this
				.getOdTcId() != null
				&& castOther.getOdTcId() != null && this.getOdTcId().equals(
				castOther.getOdTcId())))
				&& ((this.getOdTestDate() == castOther.getOdTestDate()) || (this
						.getOdTestDate() != null
						&& castOther.getOdTestDate() != null && this
						.getOdTestDate().equals(castOther.getOdTestDate())))
				&& ((this.getOdBatch() == castOther.getOdBatch()) || (this
						.getOdBatch() != null
						&& castOther.getOdBatch() != null && this.getOdBatch()
						.equals(castOther.getOdBatch())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOdTcId() == null ? 0 : this.getOdTcId().hashCode());
		result = 37
				* result
				+ (getOdTestDate() == null ? 0 : this.getOdTestDate()
						.hashCode());
		result = 37 * result
				+ (getOdBatch() == null ? 0 : this.getOdBatch().hashCode());
		return result;
	}

}