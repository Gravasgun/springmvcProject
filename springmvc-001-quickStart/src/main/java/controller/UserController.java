package controller;

import bean.Address;
import bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//定义成一个bean
@Controller
public class UserController {
    /**
     * 普通类型参数
     * @param name
     * @param age
     * @return
     */
    //设置访问路径
    @RequestMapping("/common")
    //设置当前操作的返回值类型
    @ResponseBody
    public String commonParam(String name,int age){
        System.out.println("name="+name);
        System.out.println("age="+age);
        return "{'module':'common parameter'}";
    }

    /**
     * bean类型参数
     * @param user
     * @return
     */
    //设置访问路径
    @RequestMapping("/bean")
    //设置当前操作的返回值类型
    @ResponseBody
    public String beanParam(User user){
        System.out.println("bean传参："+user.toString());
        return "{'module':'bean parameter'}";
    }

    /**
     * bean中带引用类型参数
     * @param user
     * @return
     */
    //设置访问路径
    @RequestMapping("/beanWithRef")
    //设置当前操作的返回值类型
    @ResponseBody
    public String beanParamWithReference(User user){
        System.out.println("bean中带引用传参："+user.toString());
        return "{'module':'bean with reference'}";
    }

    /**
     * 数组参数
     * @param likes
     * @return
     */
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String [] likes){
        System.out.println("likes="+Arrays.toString(likes));
        return "{'module':'array param'}";
    }

    /**
     * 集合传参
     * @param likes
     * @return
     */
    @RequestMapping("/listParam")
    @ResponseBody
    public String arrayParam(@RequestParam List<String> likes){
        System.out.println("集合likes="+likes);
        return "{'module':'array param'}";
    }

    /**
     * json数组传参
     * @param likes
     * @return
     */
    @RequestMapping("/jsonParam")
    @ResponseBody
    public String jsonParam(@RequestBody List<String> likes){
        System.out.println("json传参likes="+likes);
        return "{'module':'json param'}";
    }

    /**
     * json传参bean
     * @return
     */
    @RequestMapping("/jsonBeanParam")
    @ResponseBody
    public String jsonBeanParam(@RequestBody User user){
        System.out.println("json传参User="+user);
        return "{'module':'json user param'}";
    }

    /**
     * json对象数组
     * @param userList
     * @return
     */
    @RequestMapping("/jsonBeanArrayParam")
    @ResponseBody
    public String jsonBeanArrayParam(@RequestBody List<User> userList){
        System.out.println(userList);
        return "{'module':'json bean array param'}";
    }

    @RequestMapping("/dateTimeParam")
    @ResponseBody
    public String dateTimeParam(Date date1,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2,
                                @DateTimeFormat(pattern = "yyyy/MM/dd HH/mm/ss") Date date3){
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        return "{'module':'date param '}";
    }

    //页面跳转
    @RequestMapping("/toPage")
    //注意，此处不能加@ResponseBody,如果加了该注入，会直接将page.jsp当字符串返回前端。
    public String toPage(){
        return "page.jsp";
    }

    //响应文本数据
    @RequestMapping("/toWord")
    //注意此处该注解就不能省略，如果省略了,会把to word当前页面名称去查找，如果没有会报404
    @ResponseBody
    public String toWord(){
        return "to word";
    }

    //响应json对象
    @RequestMapping("/toJsonBean")
    @ResponseBody
    public User toJsonBean(){
        return new User("张三",22,new Address("重庆"));
    }

    //响应pojo集合对象
    @RequestMapping("/toJsonBeanList")
    @ResponseBody
    public List<User> toJsonBeanList(){
        List<User> userList=new ArrayList<>();
        userList.add(new User("张三",22,new Address("重庆")));
        userList.add(new User("李四",20,new Address("新疆")));
        return userList;
    }

    //Rest风格新增
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    @ResponseBody
    public String insert(){
        System.out.println("user save....");
        return "{'module':'rest insert'}";
    }

    //Rest风格删除
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Integer id){
        System.out.println("user delete:"+ id);
        return "{'module':'rest delete'}";
    }

    //Rest风格修改
    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user){
        System.out.println(user);
        return "{'module':'rest update'}";
    }

    //Rest风格查询
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String selectById(@PathVariable Integer id){
        System.out.println("id="+id);
        return "{'module':'rest select by id'}";
    }
}
