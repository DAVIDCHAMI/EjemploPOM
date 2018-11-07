package com.sura.reclamaciones.services;

import com.sura.service.creacionSiniestro.gen.*;
import java.util.ArrayList;
import java.util.List;

public class CreacionSiniestroFactory {

  private static final String ID_SERVICIO_CLAIM = "6";
  private static final String METHOD_CREATE_CLAIM = "createClaim";
  private static final String LOSS_TYPE_EMPRESARIAL = "PR";
  private static final String JSONRPC_2 = "2.0";

  private String policyNumber;
  private String lossDate;
  private String notificationDate;
  private String lossCause;
  private String policySystemId;
  private String descriptionLoss;
  private String description;
  private boolean isPolicyProperty;
  private String stateProperty;
  private String addressLine1Property;
  private String cityProperty;
  private String documentTypeAnt;
  private String contactNameAnt;
  private String taxIdAnt;
  private String emailAddress1Ant;
  private String cellNumberAnt;
  private String stateAnt;
  private String addressLine1Ant;
  private String cityAnt;
  private String propertyDesc;
  private String cellNumberMainContact;
  private String emailAddress1MainContact;
  private String documentTypeMainContact;
  private String taxIdMainContact;
  private String stateMainContact;
  private String addressLine1MainContact;
  private String cityMainContact;
  private String contactNameMainContact;
  private String addressLine1LossLocation;
  private String cityLossLocation;
  private String stateLossLocation;
  private int amountLossEstimate;
  private String currencyLossEstimate;
  private String authorUser;
  private String documentTypeAuthor;
  private String taxIdAuthor;
  private String nameAuthor;

  List<Object> lstVacia = new ArrayList<Object>();

  public CreacionSiniestroFactory() {}

  public String getLossDate() {
    return lossDate;
  }

  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
  }

  public void setLossDate(String lossDate) {
    this.lossDate = lossDate;
  }

  public String getNotificationDate() {
    return notificationDate;
  }

  public void setNotificationDate(String notificationDate) {
    this.notificationDate = notificationDate;
  }

  public String getLossCause() {
    return lossCause;
  }

  public void setLossCause(String lossCause) {
    this.lossCause = lossCause;
  }

  public String getPolicySystemId() {
    return policySystemId;
  }

  public void setPolicySystemId(String policySystemId) {
    this.policySystemId = policySystemId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean getIsPolicyProperty() {
    return isPolicyProperty;
  }

  public void setIsPolicyProperty(boolean isPolicyProperty) {
    this.isPolicyProperty = isPolicyProperty;
  }

  public String getStateProperty() {
    return stateProperty;
  }

  public void setStateProperty(String stateProperty) {
    this.stateProperty = stateProperty;
  }

  public String getAddressLine1Property() {
    return addressLine1Property;
  }

  public void setAddressLine1Property(String addressLine1Property) {
    this.addressLine1Property = addressLine1Property;
  }

  public String getCityProperty() {
    return cityProperty;
  }

  public void setCityProperty(String cityProperty) {
    this.cityProperty = cityProperty;
  }

  public String getDocumentTypeAnt() {
    return documentTypeAnt;
  }

  public void setDocumentTypeAnt(String documentTypeAnt) {
    this.documentTypeAnt = documentTypeAnt;
  }

  public String getContactNameAnt() {
    return contactNameAnt;
  }

  public void setContactNameAnt(String contactNameAnt) {
    this.contactNameAnt = contactNameAnt;
  }

  public String getTaxIdAnt() {
    return taxIdAnt;
  }

  public void setTaxIdAnt(String taxIdAnt) {
    this.taxIdAnt = taxIdAnt;
  }

  public String getEmailAddress1Ant() {
    return emailAddress1Ant;
  }

  public void setEmailAddress1Ant(String emailAddress1Ant) {
    this.emailAddress1Ant = emailAddress1Ant;
  }

  public String getCellNumberAnt() {
    return cellNumberAnt;
  }

  public void setCellNumberAnt(String cellNumberAnt) {
    this.cellNumberAnt = cellNumberAnt;
  }

  public String getStateAnt() {
    return stateAnt;
  }

  public void setStateAnt(String stateAnt) {
    this.stateAnt = stateAnt;
  }

  public String getAddressLine1Ant() {
    return addressLine1Ant;
  }

  public void setAddressLine1Ant(String addressLine1Ant) {
    this.addressLine1Ant = addressLine1Ant;
  }

  public String getCityAnt() {
    return cityAnt;
  }

  public void setCityAnt(String cityAnt) {
    this.cityAnt = cityAnt;
  }

  public String getPropertyDesc() {
    return propertyDesc;
  }

  public void setPropertyDesc(String propertyDesc) {
    this.propertyDesc = propertyDesc;
  }

  public String getCellNumberMainContact() {
    return cellNumberMainContact;
  }

  public void setCellNumberMainContact(String cellNumberMainContact) {
    this.cellNumberMainContact = cellNumberMainContact;
  }

  public String getEmailAddress1MainContact() {
    return emailAddress1MainContact;
  }

  public void setEmailAddress1MainContact(String emailAddress1MainContact) {
    this.emailAddress1MainContact = emailAddress1MainContact;
  }

  public String getStateMainContact() {
    return stateMainContact;
  }

  public void setStateMainContact(String stateMainContact) {
    this.stateMainContact = stateMainContact;
  }

  public String getAddressLine1MainContact() {
    return addressLine1MainContact;
  }

  public void setAddressLine1MainContact(String addressLine1MainContact) {
    this.addressLine1MainContact = addressLine1MainContact;
  }

  public String getContactNameMainContact() {
    return contactNameMainContact;
  }

  public void setContactNameMainContact(String contactNameMainContact) {
    this.contactNameMainContact = contactNameMainContact;
  }

  public String getAddressLine1LossLocation() {
    return addressLine1LossLocation;
  }

  public void setAddressLine1LossLocation(String addressLine1LossLocation) {
    this.addressLine1LossLocation = addressLine1LossLocation;
  }

  public String getCityLossLocation() {
    return cityLossLocation;
  }

  public void setCityLossLocation(String cityLossLocation) {
    this.cityLossLocation = cityLossLocation;
  }

  public String getStateLossLocation() {
    return stateLossLocation;
  }

  public void setStateLossLocation(String stateLossLocation) {
    this.stateLossLocation = stateLossLocation;
  }

  public Integer getAmountLossEstimate() {
    return amountLossEstimate;
  }

  public void setAmountLossEstimate(Integer amountLossEstimate) {
    this.amountLossEstimate = amountLossEstimate;
  }

  public String getCurrencyLossEstimate() {
    return currencyLossEstimate;
  }

  public void setCurrencyLossEstimate(String currencyLossEstimate) {
    this.currencyLossEstimate = currencyLossEstimate;
  }

  public String getNameAuthor() {
    return nameAuthor;
  }

  public void setNameAuthor(String nameAuthor) {
    this.nameAuthor = nameAuthor;
  }

  public String getDescriptionLoss() {
    return descriptionLoss;
  }

  public void setDescriptionLoss(String descriptionLoss) {
    this.descriptionLoss = descriptionLoss;
  }

  public String getAuthorUser() {
    return authorUser;
  }

  public void setAuthorUser(String authorUser) {
    this.authorUser = authorUser;
  }

  public String getDocumentTypeMainContact() {
    return documentTypeMainContact;
  }

  public void setDocumentTypeMainContact(String documentTypeMainContact) {
    this.documentTypeMainContact = documentTypeMainContact;
  }

  public String getTaxIdMainContact() {
    return taxIdMainContact;
  }

  public void setTaxIdMainContact(String taxIdMainContact) {
    this.taxIdMainContact = taxIdMainContact;
  }

  public String getCityMainContact() {
    return cityMainContact;
  }

  public void setCityMainContact(String cityMainContact) {
    this.cityMainContact = cityMainContact;
  }

  public String getDocumentTypeAuthor() {
    return documentTypeAuthor;
  }

  public void setDocumentTypeAuthor(String documentTypeAuthor) {
    this.documentTypeAuthor = documentTypeAuthor;
  }

  public String getTaxIdAuthor() {
    return taxIdAuthor;
  }

  public void setTaxIdAuthor(String taxIdAuthor) {
    this.taxIdAuthor = taxIdAuthor;
  }

  ClaimsRequest creacionSiniestroRequestFactory() {
    ClaimsRequest crearSiniestroRequest = new ClaimsRequest();
    crearSiniestroRequest.setId(ID_SERVICIO_CLAIM);
    crearSiniestroRequest.setMethod(METHOD_CREATE_CLAIM);
    crearSiniestroRequest.setParams(listParamFactory());
    crearSiniestroRequest.setJsonrpc(JSONRPC_2);
    return crearSiniestroRequest;
  }

  public List<Object> listParamFactory() {
    List<Object> listParams = new ArrayList<Object>();
    Params param = paramFactory();
    listParams.add(policyNumber);
    listParams.add(param);
    return listParams;
  }

  Params paramFactory() {
    Params param = new Params();
    param.setLossDate(getLossDate());
    param.setNotificationDate(getNotificationDate());
    param.setLossType(LOSS_TYPE_EMPRESARIAL);
    param.setLossCause(getLossCause());
    param.setLobs(lobsFactory());
    param.setMainContact(mainContactFactory());
    param.setLossLocation(lossLocationFactory());
    param.setDescription(getDescriptionLoss());
    param.setLossEstimate(lossEstimateFactory());
    param.setAuthorUser(getAuthorUser());
    param.setAuthor(authorFactory());
    return param;
  }

  Lobs lobsFactory() {
    Lobs lobs = new Lobs();
    lobs.setCPLine(cpLineFactory());
    return lobs;
  }

  CPLine cpLineFactory() {
    CPLine cpLine = new CPLine();
    cpLine.setPolicySystemId("9");
    cpLine.setFixedPropertyIncident(listFixedPropertyIncidentFactory());
    cpLine.setPropertyContentsIncident(listPropertyContentsIncidentFactory());
    return cpLine;
  }

  public List<FixedPropertyIncident> listFixedPropertyIncidentFactory() {
    List<FixedPropertyIncident> listFixedPropertyIncident = new ArrayList<FixedPropertyIncident>();
    FixedPropertyIncident fixedPropertyIncident = fixedPropertyIncidentFactory();
    listFixedPropertyIncident.add(fixedPropertyIncident);
    return listFixedPropertyIncident;
  }

  FixedPropertyIncident fixedPropertyIncidentFactory() {
    FixedPropertyIncident fixedPropertyIncident = new FixedPropertyIncident();
    fixedPropertyIncident.setDescription("Justificación valor total reclamado");
    fixedPropertyIncident.setIsPolicyProperty(true);
    fixedPropertyIncident.setProperty(propertyFactory());
    fixedPropertyIncident.setClaimant(claimantFactory());
    fixedPropertyIncident.setPropertyDesc("Justificación valor total reclamado");
    return fixedPropertyIncident;
  }

  public List<PropertyContentsIncident> listPropertyContentsIncidentFactory() {
    List<PropertyContentsIncident> listPropertyContentsIncident =
        new ArrayList<PropertyContentsIncident>();
    PropertyContentsIncident propertyContentsIncident = PropertyContentsIncident();
    listPropertyContentsIncident.add(propertyContentsIncident);
    return listPropertyContentsIncident;
  }

  PropertyContentsIncident PropertyContentsIncident() {
    PropertyContentsIncident propertyContentsIncident = new PropertyContentsIncident();
    propertyContentsIncident.setDescription("Justificación valor total reclamado");
    return propertyContentsIncident;
  }

  Property propertyFactory() {
    Property property = new Property();
    property.setState(getStateProperty());
    property.setAddressLine1(getAddressLine1Property());
    property.setCity(getCityProperty());
    return property;
  }

  Claimant claimantFactory() {
    Claimant claimant = new Claimant();
    claimant.setDocumentType(getDocumentTypeAnt());
    claimant.setContactName(getContactNameAnt());
    claimant.setTaxID(getTaxIdAnt());
    claimant.setEmailAddress1(getEmailAddress1Ant());
    claimant.setCellNumber(getCellNumberAnt());
    claimant.setPrimaryAddress(primaryAddressFactory_());
    return claimant;
  }

  PrimaryAddress_ primaryAddressFactory_() {
    PrimaryAddress_ primaryAddress_ = new PrimaryAddress_();
    primaryAddress_.setState(getStateAnt());
    primaryAddress_.setAddressLine1(getAddressLine1Ant());
    primaryAddress_.setCity(getCityAnt());
    return primaryAddress_;
  }

  MainContact mainContactFactory() {
    MainContact mainContact = new MainContact();
    mainContact.setDocumentType(getDocumentTypeMainContact());
    mainContact.setContactName(getContactNameMainContact());
    mainContact.setTaxID(getTaxIdMainContact());
    mainContact.setEmailAddress1(getEmailAddress1MainContact());
    mainContact.setCellNumber(getCellNumberMainContact());
    mainContact.setPrimaryAddress(primaryAddressFactory());
    return mainContact;
  }

  PrimaryAddress primaryAddressFactory() {
    PrimaryAddress primaryAddress = new PrimaryAddress();
    primaryAddress.setState(getStateMainContact());
    primaryAddress.setAddressLine1(getAddressLine1MainContact());
    primaryAddress.setCity(getCityMainContact());
    return primaryAddress;
  }

  LossLocation lossLocationFactory() {
    LossLocation lossLocation = new LossLocation();
    lossLocation.setState(getStateLossLocation());
    lossLocation.setAddressLine1(getAddressLine1LossLocation());
    lossLocation.setCity(getCityLossLocation());
    return lossLocation;
  }

  LossEstimate lossEstimateFactory() {
    LossEstimate lossEstimate = new LossEstimate();
    lossEstimate.setAmount(getAmountLossEstimate());
    lossEstimate.setCurrency(getCurrencyLossEstimate());
    return lossEstimate;
  }

  Author authorFactory() {
    Author author = new Author();
    author.setDocumentType(getDocumentTypeAuthor());
    author.setTaxID(getTaxIdAuthor());
    author.setName(getNameAuthor());
    return author;
  }
}
