import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

public class AutoMailer_Response
{
	private static final Logger LOGGER = Logger.getLogger(AutoMailer_Response.class.getName());

	public static void main(String[] args)
	{
		
		 PropertyConfigurator.configure("log4j.properties");
		 
		LOGGER.info("-----Start of the Program--------");
		
		AP ap_mis= new AP();
		ap_mis.fetchDataForAP();
		
		UE ue_mis= new UE();
		ue_mis.fetchDataForUE();
		
		RJ rj_mis= new RJ();
		rj_mis.fetchDataForRJ();
		
		BH bh_mis= new BH();
		bh_mis.fetchDataForBH();
		
		
		
		DL dl_mis= new DL();
		dl_mis.fetchDataForDL();
		
		KK kk_mis= new KK();
		kk_mis.fetchDataForKK();
		
		LOGGER.info("-----End of the Program--------");
	}

}
