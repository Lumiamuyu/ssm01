package Lumiamuyu.web;

import Lumiamuyu.pojo.CookiesUtil;
import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class WebTest {
    @Autowired
    private IUserService service;
    @RequestMapping("/index.do")
    public String index(ModelMap map){
        List<User> list = service.getLists();
        map.addAttribute("list",list);
        return "index";
    }

    @RequestMapping("/insert.do")
    public String insert(){
        return "insert";
    }

    @RequestMapping("/doInsert.do")
    public String doInsert(User user){
        service.insertOne(user);
        return "redirect:index.do";
    }

    @RequestMapping("/delete.do")
    public String delete(int id){
        service.delete(id);
        return "redirect:index.do";
    }

    @RequestMapping("/update.do")
    public String update(int id, Model model){
        User user = service.getOne(id);
        model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("/doUpdate.do")
    public String doUpdate(User user){
        service.update(user);
        return "redirect:index.do";
    }

    @RequestMapping("/login.do")
    public String login(){
        return "login";
    }

    @RequestMapping("/doLogin.do")
    public String doLogin(String username, String password, HttpServletRequest req, HttpServletResponse resp){
        User u = service.getUser(username);
        if (u.getPassword().equals(password)){
            HttpSession session = req.getSession();
            Cookie ucookie = new Cookie("username", username);
            Cookie pcookie = new Cookie("password", password);
            ucookie.setMaxAge(60 * 60 * 24);
            pcookie.setMaxAge(60 * 60 * 24);
            resp.addCookie(ucookie);
            resp.addCookie(pcookie);
            /*session.setMaxInactiveInterval(60*60*20);*/
            session.setAttribute("user", u);
            return "redirect:index.do";
        }
            return "redirect:login.do";

    }

    @RequestMapping("/exit.do")
    public String exit(HttpServletRequest req,HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        Map<String,Cookie> maps = CookiesUtil.getCookie(cookies);
        Cookie i =  maps.get("username");
        i.setValue("");
        i.setMaxAge(0);
        resp.addCookie(i);
        HttpSession session = req.getSession();
        session.invalidate();
        return "redirect:login.do";
    }

    @RequestMapping("/upload.do")
    public String upload(){
        return "upload";
    }


    @RequestMapping("doUpload.do")
    public String doUpload(@RequestParam("files") MultipartFile[] files) throws IOException {
        for (MultipartFile f:files
             ) {
            if (!f.isEmpty()){
                File fil = new File("D:\\new\\"+f.getOriginalFilename());
                FileUtils.copyInputStreamToFile(f.getInputStream(),fil);
            }
        }

        return "redirect:upload.do";
    }

    @RequestMapping("/list.do")
    public String list(ModelMap map,HttpServletRequest req,User user){
        int pageNum = req.getParameter("pageNum")==null?1:Integer.parseInt(req.getParameter("pageNum"));
        int pageSize = 2;
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = null;
        if (StringUtils.isBlank(user.getUsername())){
            user.setUsername(null);
            list=service.getList(user);
        }else {
            list=service.getList(user);
            String uname = "&username="+user.getUsername();
            map.addAttribute("uname",uname);
        }
        PageInfo<User> page = new PageInfo<>(list,3);
        map.addAttribute("list",list);
        map.addAttribute("page",page);
        return "list";
    }

    @RequestMapping("/register.do")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/doRegister.do")
    @ResponseBody
    public String doRegister(HttpServletRequest req,HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwords = req.getParameter("passwords");
        String email =req.getParameter("email");

        if (username != ""){
            User user = service.getUser(username);
            if (user==null){
                if (password!=""&&passwords!=""){
                    if (password.equals(passwords)){
                        return "OK";
                        /*resp.getWriter().write("3");//全匹配进行注册*/
                    }else{
                        /*resp.getWriter().write("2");//两次密码输入不一致*/
                        return "PwdNotOk";
                    }
                }
            }else {
                return "nameNotOK";
            }
        }
            return "redirect:list.do";
    }


    @RequestMapping("/regIt.do")
    @ResponseBody
    public String regIt(HttpServletRequest req,HttpServletResponse resp,User user){
        int result = service.insertOne(user);
        if (result>0){
            return "1";
        }else {
            return "0";
        }

    }

}
