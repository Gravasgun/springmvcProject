package controller;

import bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.DeptService;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 展示部门列表信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/display")
    public String display(Model model) {
        List<Dept> deptList = deptService.display();
        model.addAttribute("deptList", deptList);
        return "forward:/jsp/list.jsp";
    }

    /**
     * 删除功能
     *
     * @param deptno
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer deptno) {
        int count = deptService.delete(deptno);
        if (count == 1) {
            return "redirect:/dept/display";
        } else {
            return "redirect:/jsp/error.jsp";
        }
    }

    /**
     * 新增功能
     *
     * @param dept
     * @return
     */
    @RequestMapping("/insert")
    public String insert(Dept dept) {
        int count = deptService.insert(dept);
        if (count == 1) {
            return "redirect:/dept/display";
        } else {
            return "redirect:/jsp/error.jsp";
        }
    }

    /**
     * 展示编辑页面(查一个)
     *
     * @param dept
     * @param model
     * @return
     */
    @RequestMapping("/selectOne")
    public String selectOne(Dept dept, Model model) {
        Dept dept1 = deptService.selectOne(dept.getDeptno());
        model.addAttribute("dept", dept1);
        if (dept1 != null) {
            return "forward:/jsp/edit.jsp";
        } else {
            return "redirect:/jsp/error.jsp";
        }
    }

    /**
     * 修改功能
     *
     * @param dept
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Dept dept) {
        int count = deptService.update(dept);
        if (count == 1) {
            return "redirect:/dept/display";
        } else {
            return "redirect:/jsp/error.jsp";
        }
    }

    /**
     * 展示详情页面
     *
     * @param deptno
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String detail(Integer deptno, Model model) {
        Dept dept = deptService.selectOne(deptno);
        model.addAttribute("dept", dept);
        if (dept != null) {
            return "forward:/jsp/detail.jsp";
        } else {
            return "redirect:/jsp/error.jsp";
        }
    }
}