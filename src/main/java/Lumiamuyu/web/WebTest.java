package Lumiamuyu.web;

import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

}
