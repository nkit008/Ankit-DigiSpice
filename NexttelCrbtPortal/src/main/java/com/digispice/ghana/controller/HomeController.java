package com.digispice.ghana.controller;

import com.digispice.ghana.bean.UserDetails;
import com.digispice.ghana.dao.LoginDao;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;










@Controller
public class HomeController
{
  @Autowired
  HttpSession session;
  @Autowired
  LoginDao logindao;
  private static final Logger logger = Logger.getLogger(HomeController.class);
  

  public HomeController() {}
  

  @RequestMapping(value={"/"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String home(Locale locale, Model model)
  {
    logger.info("Welcome home! The client locale is " + locale);
    return "index";
  }
  

  @RequestMapping(value={"login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String login(@RequestParam String username, @RequestParam String password, Model model)
  {
    logger.info("Checking login credentials-- username " + username + " password " + password);
    
    List<UserDetails> list = logindao.CheckLogin(username, password);
    
    if (list.isEmpty())
    {
      model.addAttribute("wrong", "Invalid User Name and Password");
      return "index";
    }
    
    logger.info("login successfully");
    session.setAttribute("userobj", list.get(0));
      return "redirect:/mishome";
    
  }
  






  @RequestMapping({"/home"})
  public String home()
  {
    if (session.getAttribute("userobj") == null)
    {
      logger.info("--session expired--");
      return "redirect:/logout";
    }
    

    return "SearchSong";
  }
  


  @RequestMapping({"logout"})
  public String logout()
  {
    if (session.getAttribute("userobj") == null)
    {
      logger.info("--session expired--");
      return "index";
    }
    
    else
    {
        session.removeAttribute("userobj");
        session.invalidate();
        logger.info("---logout successfully!---");
        return "index";
    }
  }
}