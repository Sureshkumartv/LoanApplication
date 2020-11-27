package com.techniecode.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techniecode.beans.LoanAppIncomeResponce;
import com.techniecode.beans.LoanAppRequest;
import com.techniecode.beans.LoanAppResponce;
import com.techniecode.beans.SessionUser;
import com.techniecode.entities.LoanAppAssets;
import com.techniecode.entities.LoanAppConsents;
import com.techniecode.entities.LoanAppDeclarations;
import com.techniecode.entities.LoanAppEmployement;
import com.techniecode.entities.LoanAppFlags;
import com.techniecode.entities.LoanAppIncome;
import com.techniecode.entities.LoanAppLogin;
import com.techniecode.entities.LoanAppOtherIncome;
import com.techniecode.entities.LoanAppPension;
import com.techniecode.entities.LoanAppPersonal;
import com.techniecode.entities.LoanAppPurpose;
import com.techniecode.entities.LoanAppRental;
import com.techniecode.entities.LoanAppSocialSecurity;
import com.techniecode.entities.LoanAppStart;
import com.techniecode.repositories.LoginRepository;
import com.techniecode.services.LoanApplicationService;
import com.techniecode.services.LoanIncomeService;

@Controller
public class LoanApplicationController extends SessionHandler {

	@Autowired
	protected LoanApplicationService appService;

	@Autowired
	protected LoanIncomeService incomeService;
	@Autowired
	protected LoginRepository loginRep;

	// incomedetails
	@RequestMapping(value = "/incomedetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public   String IncomeDetails(Model model, HttpSession session,
			@RequestParam(value = "incomeid", required = false) Long incomeid,
			@RequestParam(value = "leadId", required = false) Long leadId,
			@RequestParam(value = "call", required = false) String call) {

		SessionUser sessionUser = super.getSessionUser(session);

		if (sessionUser.getRecordId() == leadId && incomeid > 0) {
			// incomeService.DeleteIncome(leadId,incomeid);
			incomeService.getCurIncomeObject(session,model, leadId, incomeid); 
		} else {
			LoanAppEmployement appObject = new LoanAppEmployement();
			model.addAttribute("app_employement", appObject);
		}
		return "pages/application/income/ajaxincome";
	}
//deleteincome

	@RequestMapping(value = "/deleteincome", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<LoanAppResponce> Deleteincome(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "incomeid", required = false) Long incomeid,
			@RequestParam(value = "leadId", required = false) Long leadId,
			@RequestParam(value = "call", required = false) String call) {
		LoanAppResponce returnValues = new LoanAppResponce();
		HttpStatus return_status = HttpStatus.OK;
		SessionUser sessionUser = super.getSessionUser(session);
		if (sessionUser.getRecordId() == leadId && incomeid > 0) {
			incomeService.DeleteIncome(leadId, incomeid);
			returnValues.setLeadId(sessionUser.getLeadId());
		}
		return ResponseEntity.status(return_status).body(returnValues);
	}// loadincomedata

	@RequestMapping(value = "/loadincomedata", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<LoanAppIncomeResponce> LoadIncomeData(HttpServletRequest request,
			HttpSession session, @RequestBody String payload) {
		LoanAppIncomeResponce returnValues = new LoanAppIncomeResponce();
		HttpStatus return_status = HttpStatus.OK;
		SessionUser sessionUser = super.getSessionUser(session);
		returnValues.setLeadId(sessionUser.getLeadId());
		if (sessionUser.getRecordId() > 0) {
			List<LoanAppIncome> incomeAppObject = appService.incomeRep.findByRecordId(sessionUser.getRecordId());
			if (incomeAppObject == null) {
				incomeAppObject = new ArrayList<LoanAppIncome>();
			}
			returnValues.setIncomeDetails(incomeAppObject.toArray(LoanAppIncome[]::new));
		}

		return ResponseEntity.status(return_status).body(returnValues);
	}

	// incomeapp
	@RequestMapping(value = "/incomeapp/{formname}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<LoanAppResponce> IncomeAppSubmit(HttpServletRequest request,
			HttpSession session, @PathVariable String formname, @RequestBody String payload) {
		LoanAppResponce returnValues = new LoanAppResponce();
		HttpStatus return_status = HttpStatus.OK;
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		SessionUser sessionUser = super.getSessionUser(session);
		LoanAppFlags appFlags = null;
		try {
			LoanAppRequest appRequest = objectMapper.readValue(payload, LoanAppRequest.class);
			appFlags = appService.appFlag.findByRecordId(appRequest.getRecordId());
			returnValues.setLeadId(appRequest.getRecordId() + "");
			if (formname.equalsIgnoreCase("employement")) {
				LoanAppEmployement app_employment = objectMapper.readValue(appRequest.getRequest(),
						LoanAppEmployement.class);

				incomeService.saveAppEmployement(app_employment, appFlags, sessionUser);
			} else if (formname.equalsIgnoreCase("rent")) {
				LoanAppRental app_rental = objectMapper.readValue(appRequest.getRequest(), LoanAppRental.class);
				incomeService.saveAppRental(app_rental, appFlags, sessionUser);
			} else if (formname.equalsIgnoreCase("ssn")) {
				LoanAppSocialSecurity app_socialsecurity = objectMapper.readValue(appRequest.getRequest(),
						LoanAppSocialSecurity.class);
				incomeService.saveAppSocailSecurity(app_socialsecurity, appFlags, sessionUser);
			} else if (formname.equalsIgnoreCase("pension")) {
				appFlags.setIncomeSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
				LoanAppPension app_socialsecurity = objectMapper.readValue(appRequest.getRequest(),
						LoanAppPension.class);
				incomeService.saveAppPension(app_socialsecurity, appFlags, sessionUser);
			} else if (formname.equalsIgnoreCase("other")) {
				appFlags.setIncomeSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
				LoanAppOtherIncome app_socialsecurity = objectMapper.readValue(appRequest.getRequest(),
						LoanAppOtherIncome.class);
				incomeService.saveAppOtherIncome(app_socialsecurity, appFlags, sessionUser);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return ResponseEntity.status(return_status).body(returnValues);
	}

	// @PostMapping(value = "/submitapp/")
	@RequestMapping(value = "/submitapp/{formname}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<LoanAppResponce> submitapp(HttpServletRequest request, HttpSession session,
			@PathVariable String formname, @RequestBody String payload) {

		HttpStatus return_status = HttpStatus.OK;
		LoanAppResponce returnValues = new LoanAppResponce();
		System.out.println("submitapp---------" + formname + "::" + payload);
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		SessionUser sessionUser = super.getSessionUser(session);
		LoanAppFlags appFlags = null;
		try {
			LoanAppRequest appRequest = objectMapper.readValue(payload, LoanAppRequest.class);
			if (sessionUser != null) {
				appRequest.setLeadId(sessionUser.getLeadId());
			}
			appFlags = appService.appFlag.findByRecordId(appRequest.getRecordId());
			if (formname != null && formname.equalsIgnoreCase("app_start") && appFlags == null) {
				appFlags = new LoanAppFlags();
				// System.out.println("---------------------Borrower First Name :"+Loan);
				// appFlags.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				LoanAppLogin login = new LoanAppLogin();
				loginRep.save(login);
				sessionUser.setLoginUser(login);
				super.setSessionUser(session, sessionUser);
				appFlags = appService.appFlag.save(appFlags);
			}

			if (appFlags != null) {
				appFlags.setApplicationPosition(appRequest.getNextPos());
				appFlags.setPrevApplicationPosition(appRequest.getCurPos());
				returnValues.setLeadId(appFlags.getRecordId() + "");

				if (sessionUser != null) {
					sessionUser.setLeadId(returnValues.getLeadId());
				}
				System.out.println("appRequest---------" + appRequest.getRequest());
				System.out.println("Formname---------- " + formname);
				if (formname != null) {
					if (formname.equalsIgnoreCase("app_start")) {
						LoanAppStart app_start = objectMapper.readValue(appRequest.getRequest(), LoanAppStart.class);
						sessionUser.getLoginUser().setEmailId(app_start.getBorrowerEmailid());
						loginRep.save(sessionUser.getLoginUser());
						appService.saveAppStart(app_start, appFlags, sessionUser);

					} else if (formname.equalsIgnoreCase("app_consents")) {
						appFlags.setConsentsSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
						LoanAppConsents app_consents = objectMapper.readValue(appRequest.getRequest(),
								LoanAppConsents.class);
						appService.saveAppConsents(app_consents, appFlags, sessionUser);

					} else if (formname.equalsIgnoreCase("app_purpose")) {
						LoanAppPurpose app_purpose = objectMapper.readValue(appRequest.getRequest(),
								LoanAppPurpose.class);
						appService.saveAppPurpose(app_purpose, appFlags, sessionUser);
					} else if (formname.equalsIgnoreCase("app_personal")) {
						appFlags.setPersonalSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
						LoanAppPersonal app_personal = objectMapper.readValue(appRequest.getRequest(),
								LoanAppPersonal.class);
						appService.saveAppPersonal(app_personal, appFlags, sessionUser);
					} else if (formname.equalsIgnoreCase("app_assets")) {
						appFlags.setAssetsSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
						LoanAppAssets app_assets = objectMapper.readValue(appRequest.getRequest(), LoanAppAssets.class);
						appService.saveAppAssets(app_assets, appFlags, sessionUser);
					} else if (formname.equalsIgnoreCase("app_declaration")) {
						appFlags.setDeclarationSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
						LoanAppDeclarations app_declarations = objectMapper.readValue(appRequest.getRequest(),
								LoanAppDeclarations.class);
						appService.saveAppDeclarations(app_declarations, appFlags, sessionUser);

					} else if (formname.equalsIgnoreCase("app_income")) {
						appFlags.setIncomeSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
						LoanAppEmployement app_employment = objectMapper.readValue(appRequest.getRequest(),
								LoanAppEmployement.class);
						// appService.saveAppIncode(app_employment,appFlags,sessionUser);
					}else if (formname.equalsIgnoreCase("app_preview")) {
						appFlags.setPreviewSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
						LoanAppEmployement app_employment = objectMapper.readValue(appRequest.getRequest(),
								LoanAppEmployement.class);
						// appService.saveAppIncode(app_employment,appFlags,sessionUser);
					}
				}

			}

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (appFlags != null) {
				// appFlags.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
				appFlags.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
				appFlags = appService.appFlag.save(appFlags);
			}
		}

		return ResponseEntity.status(return_status).body(returnValues);
	}

	@RequestMapping(value = "/loadpage", method = RequestMethod.POST)
	public String loadpage(HttpSession session, Model model, @ModelAttribute("user") LoanAppRequest request) {
		String curAppPos = request.getCurPos();
		appService.LoadFormModel(null, session, model);
		appService.LoadFormModel(curAppPos, session, model);
		model.addAttribute("pagename", curAppPos);
		System.out.println("curAppPos    ------- > "+curAppPos);
		return "pages/loan/ajaxloanapplication";
	}

	@GetMapping("/newloan")
	public String newloan(HttpSession session, Model model) {
		LoanAppFlags AppFlag = appService.storeAppFlag(session, model);
		// appService.LoadFormModel(null, session, model);
		if (!AppFlag.getApplicationPosition().equals("app_start")) {
			appService.LoadFormModel(AppFlag.getApplicationPosition(), session, model);
		}
		return "pages/loan/loanapplication";
	}

	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		System.out.println("index -------");
		return newloan(session, model);
	}

}
