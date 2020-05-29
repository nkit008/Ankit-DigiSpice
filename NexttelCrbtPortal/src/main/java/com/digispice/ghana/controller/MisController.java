package com.digispice.ghana.controller;

import com.digispice.ghana.bean.CrbtMisBean;
import com.digispice.ghana.dao.CrbtMisDao;
import com.digispice.ghana.mispoi.MISCrbtPOI;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MisController
{
  @Autowired
  HttpSession session;
  @Autowired
  CrbtMisDao misdao;
  @Autowired
  MISCrbtPOI poi;
  private static final Logger logger = LoggerFactory.getLogger(MisController.class);
  
  private String fromdate;
  
  private String todate;
  private String aceespage;
  
  public MisController() {}
  
  @RequestMapping({"/mishome"})
  public String mis_home()
  {
    if (session.getAttribute("userobj") == null)
    {
      logger.info("--session expired--");
      fromdate = null;
      todate = null;
      return "redirect:/mislogout";
    }
    



    fromdate = null;
    todate = null;
    return "mis_home";
  }
  
  @RequestMapping(value={"/mis"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String misFunstore(@RequestParam("fromDate") String fDate, @RequestParam("toDate") String endDate, @RequestParam("accessService") String aceesService, Model model)
    throws ParseException
  {
    if (session.getAttribute("userobj") == null)
    {
      logger.info("--session expired--");
      fromdate = null;
      todate = null;
      return "redirect:/mislogout";
    }
    



    fromdate = changeFormat(fDate);
    todate = changeFormat(endDate);
    logger.info("fromdate " + fDate + " enddate " + endDate);
    
    aceespage = aceesService;
    List<CrbtMisBean> misWapInternal = misdao.getMis(fromdate, todate, aceespage);
    logger.info("Size of list is " + misWapInternal.size());
    model.addAttribute("reportdata", misWapInternal);
    return "mis_home";
  }
  

  public String changeFormat(String dateString)
    throws ParseException
  {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    date = df.parse(dateString);
    DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
    return df1.format(date);
  }
  

  @RequestMapping({"mislogout"})
  public String logout()
  {
    if (session.getAttribute("userobj") == null) {
      logger.info("--session expired--");
      fromdate = null;
      todate = null;
      return "index";
    }
    

    session.removeAttribute("userobj");
    session.invalidate();
    logger.info("---logout successfully!---");
    fromdate = null;
    todate = null;
    return "index";
  }
  

  @RequestMapping({"/reportxlsCrbt"})
  public String reportxlsBhakti(HttpServletRequest request, HttpServletResponse response, Model model)
    throws ParseException
  {
    if (session.getAttribute("userobj") == null) {
      fromdate = null;
      todate = null;
      logger.info("--session expired--");
      return "index";
    }
    


    if ((fromdate != null) && (todate != null))
    {
      ClassPathResource resource = null;
      List<CrbtMisBean> misWapInternal = misdao.getMis(fromdate, todate, aceespage);
      if (misWapInternal.size() != 0)
      {
        resource = new ClassPathResource("/excel/CrbtMIS.xls");
        InputStream is = null;
        try {
          is = resource.getInputStream();
        } catch (Throwable e) {
          e.printStackTrace();
        }
        
        int startRowIndex = 0;
        int startColIndex = 3;
        poi.genrateXLS(is, startRowIndex, startColIndex, response, misWapInternal, fromdate, todate, aceespage);
      }
      
    }
    else
    {
      return "redirect:/mishome";
    }
    

    return null;
  }
  



  @RequestMapping({"/reportxlsCrbtAuto/MIS_Nexttel_CRBT_{day}.xls"})
  public String reportxlsAuto(@PathVariable String day, HttpServletRequest request, HttpServletResponse response, Model model)
    throws ParseException
  {
    System.out.println("aaa " + day);
    
    fromdate = (day.substring(0, 4) + "-" + day.substring(5, 7) + "-01");
    System.out.println("from date is " + fromdate);
    logger.info("first date is " + fromdate);
    
    todate = day;
    logger.info("prevoius date is " + todate);
    
    System.out.println("From date is " + fromdate);
    System.out.println("end date is " + todate);
    if ((fromdate != null) && (todate != null))
    {

      ClassPathResource resource = null;
      List<CrbtMisBean> misWapInternal = misdao.getMis(fromdate, todate, aceespage);
      
      if (misWapInternal.size() != 0)
      {
        resource = new ClassPathResource("/excel/CrbtMIS.xls");
        InputStream is = null;
        try {
          is = resource.getInputStream();
        } catch (Throwable e) {
          e.printStackTrace();
        }
        
        int startRowIndex = 0;
        int startColIndex = 3;
        poi.genrateXLS(is, startRowIndex, startColIndex, response, misWapInternal, fromdate, todate, aceespage);
      }
      

    }
    else
    {
      return null;
    }
    
    return null;
  }


	
	@RequestMapping(value = "/reportxlsCrbtURL")
	public void reportxlsUrl(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ParseException {
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -1);
			Date myDate=calendar.getTime();
			String todate=df1.format(myDate);
			
			
			fromdate=todate.substring(0, 4)+"-"+todate.substring(5, 7)+"-01";
			
			System.out.println(todate);
			System.out.println(fromdate);
			
			if(fromdate!=null && todate!=null)
			{
					ClassPathResource resource = null;
					List<CrbtMisBean> misWapInternal = misdao.getMis(fromdate, todate,aceespage);
					logger.info("sizr of list is "+misWapInternal.size());
					if(misWapInternal.size()!=0)
					{
						resource = new ClassPathResource("/excel/CrbtMIS.xls");
						InputStream is = null;
						try {
							is = ((InputStreamSource)resource).getInputStream();
						} catch (Throwable e) {
							e.printStackTrace();
						}
				
						int startRowIndex = 0;
						int startColIndex = 3;
						System.out.println("poiiiiii");
						poi.genrateXLS(is, startRowIndex, startColIndex, response, misWapInternal,fromdate,todate,aceespage);
					}
			}
		}
	

}
