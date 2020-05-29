package com.spice.vchatinterfacebulk.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(
        name="VChat_UserInterface_PartnerReqUpdate",
        procedureName="VChat_UserInterface_PartnerReqUpdate",
        parameters={        		
        		@StoredProcedureParameter(name="IN_HUB",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_REQUEST_TYPE",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_REQUEST_INSERTDATE",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_REQUESTED_NAME",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_NUMBER",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_NEW_NUMBER",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_REQUESTED_CIRCLE",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_REQUESTED_CHATID",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_REQUESTED_LOCATION",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_REQUESTED_TYPE",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_DOCUMENT",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_DOCUMENT_NUMBER",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_AGENT_NAME",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_AGENT_AGE",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_AGENT_LANGUAGES",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_PARTNER_REMARKS",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_ADMIN_REMARKS",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_STATUS",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_AGENTDOCIMAGE",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_PARTNERCERTIMAGE",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_UPDATEDBY",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="IN_REQID",mode=ParameterMode.IN,type=String.class),
        		@StoredProcedureParameter(name="OUT_RESP",mode=ParameterMode.IN,type=String.class)
        }
)

public class ProcPartnerReqUpdate {

	@Id
	private int id;
	
	
}
