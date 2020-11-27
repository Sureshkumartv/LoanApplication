package com.techniecode.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.techniecode.beans.SessionUser;
import com.techniecode.controller.SessionHandler;
import com.techniecode.entities.LoanAppAssets;
import com.techniecode.entities.LoanAppConsents;
import com.techniecode.entities.LoanAppDeclarations;
import com.techniecode.entities.LoanAppEmployement;
import com.techniecode.entities.LoanAppFlags;
import com.techniecode.entities.LoanAppIncome;
import com.techniecode.entities.LoanAppOtherIncome;
import com.techniecode.entities.LoanAppPension;
import com.techniecode.entities.LoanAppPersonal;
import com.techniecode.entities.LoanAppPurpose;
import com.techniecode.entities.LoanAppRental;
import com.techniecode.entities.LoanAppSocialSecurity;
import com.techniecode.entities.LoanAppStart;
import com.techniecode.entities.LoanAppStates;
import com.techniecode.repositories.LoanAppAssetsRepository;
import com.techniecode.repositories.LoanAppConsentsRepository;
import com.techniecode.repositories.LoanAppDeclarationsRepository;
import com.techniecode.repositories.LoanAppFlagsRepository;
import com.techniecode.repositories.LoanAppIncomeRepository;
import com.techniecode.repositories.LoanAppPersonalRepository;
import com.techniecode.repositories.LoanAppPurposeRepository;
import com.techniecode.repositories.LoanAppStartRepository;
import com.techniecode.repositories.LoanAppStatesRepository;

@Service
public class LoanApplicationService extends SessionHandler {

	// @Autowired
	// protected LoanAppFlagsRepository appFlagsRep;

	@Autowired
	public LoanAppStartRepository appStartRep;
	@Autowired
	public LoanAppConsentsRepository appLoanConsentsRep;
	@Autowired
	public LoanAppFlagsRepository appFlag;
	@Autowired
	public LoanAppPurposeRepository appLoanPurposeRep;
	@Autowired
	public LoanAppPersonalRepository appLoanPersonalRep;
	@Autowired
	public LoanAppAssetsRepository appLoanAssetsRep;
	@Autowired
	public LoanAppDeclarationsRepository appLoanDeclarationsRep;
	@Autowired
	public LoanAppIncomeRepository incomeRep;
	@Autowired
	public LoanAppStatesRepository appLoanStatesRep;

	private LoanAppFlags appFlagsObject = null;
	private LoanAppStart appStartObject = null;

	public LoanAppFlags getCurrentApplication(SessionUser sessionUser) {
		// TODO Auto-generated method stub
		LoanAppFlags appFlagsObject = null;
		if (sessionUser.isExist() && sessionUser.isLeadExist()) {
			System.out.println("**********************RecordID *****************" + sessionUser.getRecordId());
			// appFlagsObject = appFlagsRep.findByRecordId(sessionUser.getRecordId());
			appFlagsObject = appFlag.findByRecordId(sessionUser.getRecordId());

		} else if (sessionUser.getLoginUser() != null) {

			List<LoanAppFlags> allaps = appFlag
					.findTop1ByCreatedByOrderByRecordIdDesc(sessionUser.getLoginUser().getLoginId());
			if (allaps != null && allaps.size() > 0) {
				appFlagsObject = allaps.get(0);
			}
		}
		if (appFlagsObject != null) {
			sessionUser.setLeadId(appFlagsObject.getRecordId() + "");
		}
		return appFlagsObject;
	}

	public void LoadFormModel(String curAppPos, HttpSession session, Model model) {
		// TODO Auto-generated method stub
		// storeAppStart(session, model);
		if (curAppPos == null || curAppPos.equalsIgnoreCase("app_start")) {
			storeAppStart(session, model);
		} else if (curAppPos.equalsIgnoreCase("app_consents")) {
			storeAppConsents(session, model);
		} else if (curAppPos.equalsIgnoreCase("app_purpose")) {
			storeAppPurpose(session, model);
		} else if (curAppPos.equalsIgnoreCase("app_personal")) {
			storeAppPersonal(session, model);
		} else if (curAppPos.equalsIgnoreCase("app_assets")) {
			storeAppAssets(session, model);
		} else if (curAppPos.equalsIgnoreCase("app_declaration")) {
			storeAppDeclarations(session, model);
		} else if (curAppPos.equalsIgnoreCase("app_income")) {
			storeAppIncome(session, model);
		}
		else if (curAppPos.equalsIgnoreCase("app_preview")) {
			storeAppPreview(session, model);
		}
	}

	private  LoanAppStart storeAppPreview(HttpSession session, Model model) {
		// TODO Auto-generated method stub
		System.out.println("**********************app_preview *****************");
		SessionUser sessionUser = super.getSessionUser(session);
		appStartObject = appStartRep.findByRecordId(sessionUser.getRecordId());
		LoanAppConsents appConsentsObject = appLoanConsentsRep.findByRecordId(sessionUser.getRecordId());
		LoanAppPurpose appPurposeObject = appLoanPurposeRep.findByRecordId(sessionUser.getRecordId());
		LoanAppPersonal appPersonalObject = appLoanPersonalRep.findByRecordId(sessionUser.getRecordId());
		LoanAppDeclarations appDeclarationsObject = appLoanDeclarationsRep.findByRecordId(sessionUser.getRecordId());
		LoanAppAssets appAssetsObject = appLoanAssetsRep.findByRecordId(sessionUser.getRecordId());
		model.addAttribute("app_start", appStartObject);
		model.addAttribute("app_consents", appConsentsObject);
		model.addAttribute("app_purpose", appPurposeObject);
		model.addAttribute("app_personal", appPersonalObject);
		model.addAttribute("app_declarations", appDeclarationsObject);
		model.addAttribute("app_assets", appAssetsObject);
		return appStartObject;
	}

	private LoanAppEmployement storeAppIncome(HttpSession session, Model model) {
		// TODO Auto-generated method stub
		System.out.println("**********************app_income *****************");
		SessionUser sessionUser = super.getSessionUser(session);
		// List<LoanAppIncome> incomeAppObject =
		// incomeRep.findByRecordId(sessionUser.getRecordId());
		// if (incomeAppObject == null) {
		List<LoanAppIncome> incomeAppObject = new ArrayList<LoanAppIncome>();
		// }
		LoanAppEmployement appObject = new LoanAppEmployement();
		LoanAppRental appRentalObject = new LoanAppRental();
		LoanAppSocialSecurity appSSObject = new LoanAppSocialSecurity();
		LoanAppPension appPensionObject = new LoanAppPension();
		LoanAppOtherIncome appOtherIncomeObj = new LoanAppOtherIncome();

		List<LoanAppStates> stateObj = appLoanStatesRep.findAll();

		model.addAttribute("states", stateObj);
		model.addAttribute("app_income", incomeAppObject);
		model.addAttribute("app_employement", appObject);
		model.addAttribute("app_rental", appRentalObject);
		model.addAttribute("app_socialsecurity", appSSObject);
		model.addAttribute("app_pension", appPensionObject);
		model.addAttribute("app_otherincome", appOtherIncomeObj);

		return appObject;
	}

	private LoanAppDeclarations storeAppDeclarations(HttpSession session, Model model) {
		// TODO Auto-generated method stub
		System.out.println("**********************app_declarations :storeAppDeclarations *****************");
		SessionUser sessionUser = super.getSessionUser(session);
		LoanAppDeclarations appObject = appLoanDeclarationsRep.findByRecordId(sessionUser.getRecordId());
		if (appObject == null) {
			appObject = new LoanAppDeclarations();
		}
		model.addAttribute("app_declarations", appObject);
		return appObject;
	}

	private LoanAppAssets storeAppAssets(HttpSession session, Model model) {
		// TODO Auto-generated method stub
		System.out.println("**********************app_assets *****************");
		SessionUser sessionUser = super.getSessionUser(session);
		LoanAppAssets appObject = appLoanAssetsRep.findByRecordId(sessionUser.getRecordId());
		if (appObject == null) {
			appObject = new LoanAppAssets();
			appObject.setAccountOwner("borr");
		}
		model.addAttribute("app_assets", appObject);
		return appObject;

	}

	public LoanAppPersonal storeAppPersonal(HttpSession session, Model model) {
		System.out.println("**********************app_personal *****************");
		SessionUser sessionUser = super.getSessionUser(session);
		LoanAppPersonal appObject = appLoanPersonalRep.findByRecordId(sessionUser.getRecordId());
		List<LoanAppStates> stateObj = appLoanStatesRep.findAll();
		if (appObject == null) {
			appObject = new LoanAppPersonal();
			appObject.setCurrentMailingAddress("Yes");
			appObject.setBorrowerName("borr");
			appObject.setCoCurrentMailingAddress("Yes");
			appObject.setHouseType("Own");
			appObject.setCoHouseType("Own");

			if (appStartObject != null) {
				appObject.setEmailId(appStartObject.getBorrowerEmailid());
				appObject.setCellPhone(appStartObject.getBorrowerCellphone());
				appObject.setCoEmailId(appStartObject.getCoBorrowerEmailid());
				appObject.setCoCellPhone(appStartObject.getCoBorrowerCellphone());

			}
		}
		model.addAttribute("states", stateObj);
		model.addAttribute("app_personal", appObject);
		return appObject;
	}

	public LoanAppPurpose storeAppPurpose(HttpSession session, Model model) {
		System.out.println("**********************app_consents *****************");
		SessionUser sessionUser = super.getSessionUser(session);
		LoanAppPurpose appObject = appLoanPurposeRep.findByRecordId(sessionUser.getRecordId());
		List<LoanAppStates> stateObj = appLoanStatesRep.findAll();
		if (appObject == null) {
			appObject = new LoanAppPurpose();
			appObject.setMortgagePurpose(0);
		}
		model.addAttribute("states", stateObj);
		model.addAttribute("app_purpose", appObject);
		return appObject;
	}

	public LoanAppFlags storeAppFlag(HttpSession session, Model model) {
		System.out.println("**********************app_flag *****************");
		SessionUser sessionUser = super.getSessionUser(session);
		LoanAppFlags appFlagsObject = getCurrentApplication(sessionUser);
		if (appFlagsObject == null) {
			appFlagsObject = new LoanAppFlags();
			appFlagsObject.setApplicationPosition("app_start");
		}
		LoanAppStart appStartObject = appFlagsObject.getApp_start();
		if (appFlagsObject.getApp_start() == null) {
			appStartObject = new LoanAppStart();
			// appStartObject.setBorrowerFirstName(sessionUser.getLoginUser().getFirstName());
			// appStartObject.setBorrowerLastName(sessionUser.getLoginUser().getLastName());
			// appStartObject.setBorrowerEmailid(sessionUser.getLoginUser().getEmailId());
			// appStartObject.setBorrowerCellphone(sessionUser.getLoginUser().getPhoneNumber());
		}
		model.addAttribute("app_start", appStartObject);
		model.addAttribute("app_flag", appFlagsObject);
		return appFlagsObject;
	}

	public LoanAppStart storeAppStart(HttpSession session, Model model) {
		System.out.println("**********************getAppStart *****************");
		SessionUser sessionUser = super.getSessionUser(session);
		appStartObject = appStartRep.findByRecordId(sessionUser.getRecordId());
		if (appStartObject == null && !session.isNew()) {
			appStartObject = new LoanAppStart();
			appStartObject.setBorrowerFirstName(sessionUser.getLoginUser().getFirstName());
			appStartObject.setBorrowerLastName(sessionUser.getLoginUser().getLastName());
			appStartObject.setBorrowerEmailid(sessionUser.getLoginUser().getEmailId());
			appStartObject.setBorrowerCellphone(sessionUser.getLoginUser().getPhoneNumber());
		}
		if (sessionUser != null) {
			sessionUser.setAppStartObject(appStartObject);
		}
		model.addAttribute("app_start", appStartObject);
		return appStartObject;
	}

	public LoanAppConsents storeAppConsents(HttpSession session, Model model) {
		System.out.println("**********************app_consents *****************");
		SessionUser sessionUser = super.getSessionUser(session);
		LoanAppConsents appAssetsObject = appLoanConsentsRep.findByRecordId(sessionUser.getRecordId());
		if (appAssetsObject == null) {
			appAssetsObject = new LoanAppConsents();
		}
		model.addAttribute("app_consents", appAssetsObject);
		return appAssetsObject;
	}

	public void saveAppStart(LoanAppStart app_start, LoanAppFlags appFlags, SessionUser sessionUser) {
		// TODO Auto-generated method stub
		if (app_start != null) {
			if (appFlags.getStartSubmit() == null) {
				app_start.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_start.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_start.setRecordId(appFlags.getRecordId());
			app_start.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_start.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			// LoanAppStart startObj =appStartRep.findByRecordId(appFlags.getRecordId());
			// if(startObj==null) {
			app_start = appStartRep.save(app_start);
			// }else {
			// app_start = appStartRep.
			// }
		}
		appFlags.setStartSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
	}

	public void saveAppPurpose(LoanAppPurpose app_purpose, LoanAppFlags appFlags, SessionUser sessionUser) {
		// TODO Auto-generated method stub
		if (app_purpose != null) {
			if (appFlags.getPurposeSubmit() == null) {
				app_purpose.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_purpose.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_purpose.setRecordId(appFlags.getRecordId());
			app_purpose.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_purpose.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_purpose = appLoanPurposeRep.save(app_purpose);
		}
		appFlags.setPurposeSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));

	}

	public void saveAppPersonal(LoanAppPersonal app_personal, LoanAppFlags appFlags, SessionUser sessionUser) {
		// TODO Auto-generated method stub
		if (app_personal != null) {
			if (appFlags.getPersonalSubmit() == null) {
				app_personal.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_personal.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_personal.setRecordId(appFlags.getRecordId());
			app_personal.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_personal.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_personal = appLoanPersonalRep.save(app_personal);
		}
		appFlags.setPersonalSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
	}

	public void saveAppConsents(LoanAppConsents app_consents, LoanAppFlags appFlags, SessionUser sessionUser) {
		// TODO Auto-generated method stub
		if (app_consents != null) {
			if (appFlags.getConsentsSubmit() == null) {
				app_consents.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_consents.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_consents.setRecordId(appFlags.getRecordId());
			app_consents.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_consents.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_consents = appLoanConsentsRep.save(app_consents);
		}
		appFlags.setConsentsSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
	}

	public void saveAppAssets(LoanAppAssets app_assets, LoanAppFlags appFlags, SessionUser sessionUser) {
		// TODO Auto-generated method stub
		System.out.println("**************************** Save Assets ******************************");
		if (app_assets != null) {
			if (appFlags.getAssetsSubmit() == null) {
				app_assets.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_assets.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_assets.setRecordId(appFlags.getRecordId());
			app_assets.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_assets.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_assets = appLoanAssetsRep.save(app_assets);
		}
		appFlags.setAssetsSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
	}

	public void saveAppDeclarations(LoanAppDeclarations app_declarations, LoanAppFlags appFlags,
			SessionUser sessionUser) {
		// TODO Auto-generated method stub
		System.out.println("*********************save Declarations *******************");
		if (app_declarations != null) {
			if (appFlags.getDeclarationSubmit() == null) {
				app_declarations.setCreatedBy(sessionUser.getLoginUser().getLoginId());
				app_declarations.setCreatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			}
			app_declarations.setRecordId(appFlags.getRecordId());
			app_declarations.setUpdatedBy(sessionUser.getLoginUser().getLoginId());
			app_declarations.setUpdatedDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
			app_declarations = appLoanDeclarationsRep.save(app_declarations);
		}
		appFlags.setDeclarationSubmit((java.sql.Timestamp.valueOf(LocalDateTime.now())));
	}

}
