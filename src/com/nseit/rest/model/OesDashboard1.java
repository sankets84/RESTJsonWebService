package com.nseit.rest.model;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.nseit.rest.type.JSONObjectUserType;

@Entity
//@JsonAutoDetect 
@Table(name = "oes_dashboard1")
@TypeDefs({ @TypeDef(name = "CustomJsonObject", typeClass = JSONObjectUserType.class) })
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class OesDashboard1 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -955129794087690926L;
	// Fields

	private OesDashboardId id;
	private Timestamp odAuditDt;
	//@JsonProperty
	private JSONObject odContent;

	// Constructors

	/** default constructor */
	public OesDashboard1() {
	}

	/** minimal constructor */
	public OesDashboard1(OesDashboardId id) {
		this.id = id;
	}

	/** full constructor */
	public OesDashboard1(OesDashboardId id, Timestamp odAuditDt, JSONObject odContent) {
		this.id = id;
		this.odAuditDt = odAuditDt;
		this.odContent = odContent;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
	@AttributeOverride(name = "odTcId", column = @Column(name = "od_tc_id", nullable = false)),
	@AttributeOverride(name = "odTestDate", column = @Column(name = "od_test_date", nullable = false)),
	@AttributeOverride(name = "odBatch", column = @Column(name = "od_batch", nullable = false)) })
	public OesDashboardId getId() {
		return this.id;
	}

	public void setId(OesDashboardId id) {
		this.id = id;
	}

	@Column(name = "od_audit_dt", length = 29)
	public Timestamp getOdAuditDt() {
		return this.odAuditDt;
	}

	public void setOdAuditDt(Timestamp odAuditDt) {
		this.odAuditDt = odAuditDt;
	}

	@Column(name = "od_content")
	@Type(type = "CustomJsonObject")
	public JSONObject getOdContent() {
		return this.odContent;
	}

	public void setOdContent(JSONObject odContent) {
		this.odContent = odContent;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OesDashboard1))
			return false;
		OesDashboard1 castOther = (OesDashboard1) other;

		return ((this.getId() == castOther.getId()) || (this
				.getId()!= null
				&& castOther.getOdAuditDt() != null && this.getOdAuditDt().equals(
				castOther. getOdAuditDt())))
				&& ((this.getOdAuditDt() == castOther.getOdAuditDt()) || (this
						.getOdAuditDt() != null
						&& castOther.getOdAuditDt() != null && this
						.getOdAuditDt().equals(castOther.getOdAuditDt())))
				&& ((this.getOdContent().toString() == castOther.getOdContent().toString()) || (this
						.getOdContent() != null
						&& castOther.getOdContent()!= null && this.getOdContent().toString()
						.equals(castOther.getOdContent().toString())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getOdAuditDt() == null ? 0 : this.getOdAuditDt()
						.hashCode());
		result = 37 * result
				+ (getOdContent() == null ? 0 : this.getOdContent().toString().hashCode());
		return result;
	}


}
