package net.javaguides.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "case_storage")
public class CaseEntity {

	@Id
	@Column(
			name = "id",
			columnDefinition = "varchar(40)",
			nullable = false,
			updatable = false
	)
	private String id;

	@Column(name = "case_number", columnDefinition = "varchar(10)")
	private String caseNumber;

	@Column(name = "case_name", columnDefinition = "varchar(40)")
	private String caseName;


	@Column(name = "case_brief", columnDefinition = "varchar(1024)")
	private String caseBrief;


	@Column(name = "first_party_name", columnDefinition = "varchar(256)")
	private String firstPartyName;

	@Column(name = "second_party_name", columnDefinition = "varchar(256)")
	private String secondPartyName;

	@Column(name = "first_party_email", columnDefinition = "varchar(100)")
	private String firstPartyEmail;

	@Column(name = "second_party_phone", columnDefinition = "varchar(15)")
	private String secondPartyPhone;

	@Column(name = "second_party_email", columnDefinition = "varchar(100)")
	private String secondPartyEmail;

	@Column(name = "first_party_phone", columnDefinition = "varchar(15)")
	private String firstPartyPhone;

	@Column(name = "court_hall", columnDefinition = "varchar(50)")
	private String courtHall;

	@Column(name = "court_type", columnDefinition = "varchar(50)")
	private String courtType;

	@Column(name = "registered_date", columnDefinition = "DATETIME")
	private String registeredDate;

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getFirstPartyName() {
		return firstPartyName;
	}

	public void setFirstPartyName(String firstPartyName) {
		this.firstPartyName = firstPartyName;
	}

	public String getSecondPartyName() {
		return secondPartyName;
	}

	public void setSecondPartyName(String secondPartyName) {
		this.secondPartyName = secondPartyName;
	}

	public String getFirstPartyEmail() {
		return firstPartyEmail;
	}

	public void setFirstPartyEmail(String firstPartyEmail) {
		this.firstPartyEmail = firstPartyEmail;
	}

	public String getSecondPartyPhone() {
		return secondPartyPhone;
	}

	public void setSecondPartyPhone(String secondPartyPhone) {
		this.secondPartyPhone = secondPartyPhone;
	}

	public String getSecondPartyEmail() {
		return secondPartyEmail;
	}

	public void setSecondPartyEmail(String secondPartyEmail) {
		this.secondPartyEmail = secondPartyEmail;
	}

	public String getFirstPartyPhone() {
		return firstPartyPhone;
	}

	public void setFirstPartyPhone(String firstPartyPhone) {
		this.firstPartyPhone = firstPartyPhone;
	}

	public String getCourtHall() {
		return courtHall;
	}

	public void setCourtHall(String courtHall) {
		this.courtHall = courtHall;
	}

	public String getCourtType() {
		return courtType;
	}

	public void setCourtType(String courtType) {
		this.courtType = courtType;
	}

	public String getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getCaseBrief() {
		return caseBrief;
	}

	public void setCaseBrief(String caseBrief) {
		this.caseBrief = caseBrief;
	}
}
