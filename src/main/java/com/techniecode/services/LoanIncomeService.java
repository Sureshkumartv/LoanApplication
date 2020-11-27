package com.techniecode.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.techniecode.beans.LoanAppIncomeResponce;
import com.techniecode.beans.SessionUser;
import com.techniecode.controller.SessionHandler;
import com.techniecode.entities.LoanAppEmployement;
import com.techniecode.entities.LoanAppFlags;
import com.techniecode.entities.LoanAppIncome;
import com.techniecode.entities.LoanAppOtherIncome;
import com.techniecode.entities.LoanAppPension;
import com.techniecode.entities.LoanAppRental;
import com.techniecode.entities.LoanAppSocialSecurity;
import com.techniecode.entities.LoanAppStates;
import com.techniecode.repositories.LoanAppEmployementRepository;
import com.techniecode.repositories.LoanAppFlagsRepository;
import com.techniecode.repositories.LoanAppIncomeRepository;
import com.techniecode.repositories.LoanAppOtherIncomeRepository;
import com.techniecode.repositories.LoanAppPensionRepository;
import com.techniecode.repositories.LoanAppRentalRepository;
import com.techniecode.repositories.LoanAppSocialSecurityRepository;

@Service
public class LoanIncomeService extends SessionHandler {

	// @Autowired
	// protected LoanAppFlagsRepository appFlagsRep;

	@Autowired
	public LoanAppFlagsRepository appFlag;
	@Autowired
	public LoanAppIncomeRepository appIncomeRep;
	@Autowired
	public LoanAppEmployementRepository appLoanEmployementRep;
	@Autowired
	public LoanAppRentalRepository appLoanRentalRep;

	@Autowired
	public LoanAppSocialSecurityRepository appLoanSocialSecurityRep;
	@Autowired
	public LoanAppPensionRepository appLoanPensionRep;
	@Autowired
	public LoanAppOtherIncomeRepository appLoanOtherIncomeRep;

	public void saveAppEmployement(LoanAppEmployement app_employment, LoanAppFlags appFlags, SessionUser sessionUser) {
		// TODO Auto-generated method stub
		if (app_employment != null) {

			LoanAppIncome app_income = new LoanAppIncome();
			app_income.setId(app_employment.getIncomeId());
			
			app_income.setCreatedBy(sessionUser.getLoginUser().getLoginId());
			app_income.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_income.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_income.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_income.setRecordId(appFlags.getRecordId());
			app_income.setAccountOwner(app_employment.getBorrowerName());
			app_income.setIncomeType("employement");
			app_income.setIncomeAmount(app_employment.getAnualBaseSalary());
			if (app_employment.getIncomeId() == null) {
				app_income.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_income.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
				app_employment.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_employment.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_income = appIncomeRep.save(app_income);

			app_employment.setCreatedBy(sessionUser.getLoginUser().getLoginId());
			app_employment.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_employment.setIncomeId(app_income.getId());
			app_employment.setRecordId(appFlags.getRecordId());
			app_employment.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_employment.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_employment = appLoanEmployementRep.save(app_employment);

		}
		// appFlags.setIncomeSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
	}

	public void saveAppRental(LoanAppRental app_rental, LoanAppFlags appFlags, SessionUser sessionUser) {
		// TODO Auto-generated method stub
		if (app_rental != null) {
			LoanAppIncome app_income = new LoanAppIncome();
			app_income.setId(app_rental.getIncomeId());

			app_income.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_income.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_income.setRecordId(appFlags.getRecordId());
			app_income.setAccountOwner(app_rental.getRentalPropertyOwner());
			app_income.setIncomeType("rental");
			app_income.setIncomeAmount(app_rental.getRentalMonthlyRent());

			if (app_rental.getIncomeId() == null) {
				app_income.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_income.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
				app_rental.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_rental.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_income = appIncomeRep.save(app_income);

			app_rental.setIncomeId(app_income.getId());
			app_rental.setRecordId(appFlags.getRecordId());
			app_rental.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_rental.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_rental = appLoanRentalRep.save(app_rental);

		}
		// appFlags.setIncomeSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
	}

	public void saveAppSocailSecurity(LoanAppSocialSecurity app_socialsecurity, LoanAppFlags appFlags,
			SessionUser sessionUser) {
		// TODO Auto-generated method stub
		if (app_socialsecurity != null) {

			LoanAppIncome app_income = new LoanAppIncome();
			app_income.setId(app_socialsecurity.getIncomeId());

			app_income.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_income.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_income.setRecordId(appFlags.getRecordId());
			app_income.setAccountOwner(app_socialsecurity.getAccountOwner());
			app_income.setIncomeType("socialsecurity");
			app_income.setIncomeAmount(app_socialsecurity.getAnualIncome());
			if (app_socialsecurity.getIncomeId() == null) {
				app_income.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_income.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
				app_socialsecurity.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_socialsecurity.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_income = appIncomeRep.save(app_income);

			app_socialsecurity.setIncomeId(app_income.getId());
			app_socialsecurity.setRecordId(appFlags.getRecordId());
			app_socialsecurity.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_socialsecurity.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_socialsecurity = appLoanSocialSecurityRep.save(app_socialsecurity);

		}
		appFlags.setIncomeSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
	}

	public void saveAppPension(LoanAppPension app_pension, LoanAppFlags appFlags, SessionUser sessionUser) {
		// TODO Auto-generated method stub
		if (app_pension != null) {

			LoanAppIncome app_income = new LoanAppIncome();

			app_income.setId(app_pension.getIncomeId());

			app_income.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_income.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_income.setRecordId(appFlags.getRecordId());
			app_income.setAccountOwner(app_pension.getAccountOwner());
			app_income.setIncomeType("pension");
			app_income.setIncomeAmount(app_pension.getAnualIncome());
			if (app_pension.getIncomeId() == null) {
				app_income.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_income.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
				app_pension.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_pension.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_income = appIncomeRep.save(app_income);

			app_pension.setIncomeId(app_income.getId());
			app_pension.setRecordId(appFlags.getRecordId());
			app_pension.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_pension.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_pension = appLoanPensionRep.save(app_pension);

		}
		appFlags.setIncomeSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
	}

	public void saveAppOtherIncome(LoanAppOtherIncome app_otherincome, LoanAppFlags appFlags, SessionUser sessionUser) {
		// TODO Auto-generated method stub
		if (app_otherincome != null) {

			LoanAppIncome app_income = new LoanAppIncome();
			app_income.setId(app_otherincome.getIncomeId());
			
			app_income.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_income.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_income.setRecordId(appFlags.getRecordId());
			app_income.setAccountOwner(app_otherincome.getAccountOwner());
			app_income.setIncomeType("otherincome");
			app_income.setIncomeAmount(app_otherincome.getAnnualBaseSalary());
			if (app_otherincome.getIncomeId() == null) {
				app_income.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_income.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
				app_otherincome.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_otherincome.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_income = appIncomeRep.save(app_income);

			app_otherincome.setIncomeId(app_income.getId());
			app_otherincome.setRecordId(appFlags.getRecordId());
			app_otherincome.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_otherincome.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_otherincome = appLoanOtherIncomeRep.save(app_otherincome);

		}
		appFlags.setIncomeSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
	}

	public void DeleteIncome(Long leadId, Long incomeid) {
		// TODO Auto-generated method stub
		LoanAppSocialSecurity app_socialsecurity = new LoanAppSocialSecurity();
		app_socialsecurity.setRecordId(leadId);
		app_socialsecurity.setIncomeId(incomeid);
		appLoanSocialSecurityRep.delete(app_socialsecurity);

		LoanAppOtherIncome app_otherIncome = new LoanAppOtherIncome();
		app_otherIncome.setRecordId(leadId);
		app_otherIncome.setIncomeId(incomeid);
		appLoanOtherIncomeRep.delete(app_otherIncome);

		LoanAppRental app_rental = new LoanAppRental();
		app_rental.setRecordId(leadId);
		app_rental.setIncomeId(incomeid);
		appLoanRentalRep.delete(app_rental);

		LoanAppPension app_pension = new LoanAppPension();
		app_pension.setRecordId(leadId);
		app_pension.setIncomeId(incomeid);
		appLoanPensionRep.delete(app_pension);

		LoanAppEmployement appEmployement = new LoanAppEmployement();
		appEmployement.setRecordId(leadId);
		appEmployement.setIncomeId(incomeid);
		appLoanEmployementRep.delete(appEmployement);

		LoanAppIncome app_income = new LoanAppIncome();
		app_income.setId(incomeid);
		appIncomeRep.delete(app_income);
	}

	public void getCurIncomeObject( HttpSession session, Model model, Long recordId, Long incomeId) {
		// TODO Auto-generated method stub
		Optional<LoanAppIncome> income = appIncomeRep.findById(incomeId);
		SessionUser sessionUser = super.getSessionUser(session);
		if (sessionUser != null) {
		 	model.addAttribute("app_start", sessionUser.getAppStartObject());
		}
		
		if (income != null) {
			String incomeType = income.get().getIncomeType();
			model.addAttribute("pagename", "app_"+incomeType) ;
			if (incomeType != null) {
				if (incomeType.equalsIgnoreCase("employement")) {
					LoanAppEmployement appObject = appLoanEmployementRep.findByRecordIdAndIncomeId(recordId, incomeId);
					if (appObject == null) {
						appObject = new LoanAppEmployement();
					}
					model.addAttribute("app_employement", appObject);
				} else if (incomeType.equalsIgnoreCase("rental")) {
					LoanAppRental appRentalObject = appLoanRentalRep.findByRecordIdAndIncomeId(recordId, incomeId);
					if (appRentalObject == null) {
						appRentalObject = new LoanAppRental();
					}
					model.addAttribute("app_rental", appRentalObject);

				} else if (incomeType.equalsIgnoreCase("socialsecurity")) {
					LoanAppSocialSecurity appSSObject = appLoanSocialSecurityRep.findByRecordIdAndIncomeId(recordId,
							incomeId);
					if (appSSObject == null) {
						appSSObject = new LoanAppSocialSecurity();
					}
					model.addAttribute("app_socialsecurity", appSSObject);

				} else if (incomeType.equalsIgnoreCase("pension")) {
					LoanAppPension appPensionObject = appLoanPensionRep.findByRecordIdAndIncomeId(recordId, incomeId);
					if (appPensionObject == null) {
						appPensionObject = new LoanAppPension();
					}
					model.addAttribute("app_pension", appPensionObject);
					return;
				} else if (incomeType.equalsIgnoreCase("otherincome")) {
					LoanAppOtherIncome appOtherIncomeObj = appLoanOtherIncomeRep.findByRecordIdAndIncomeId(recordId, incomeId);
 					if (appOtherIncomeObj == null) {
						appOtherIncomeObj = new LoanAppOtherIncome();
					}
					model.addAttribute("app_otherincome", appOtherIncomeObj);
				}
			}

		}

	}
}
