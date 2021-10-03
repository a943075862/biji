package com.qf.java2102.ssm.web.controller;

import com.github.pagehelper.PageInfo;
import com.qf.java2102.ssm.entity.ResultVO;
import com.qf.java2102.ssm.pojo.Department;
import com.qf.java2102.ssm.pojo.Employee;
import com.qf.java2102.ssm.service.IDepartmentService;
import com.qf.java2102.ssm.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author ghy
 * @version 1.0
 */
@Controller
@RequestMapping("/employee")
@Slf4j
public class IEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/edit")
    public String edit(Employee employee){
        log.info("employee:{}", employee);
        employeeService.edit(employee);
        return "redirect:/employee/list";
    }


    @RequestMapping("/editUI/{id}")
    public String editUI(Model model, @PathVariable("id") Long id){
        log.info("editUI----------------->id:{}", id);
        Map<String, Object> result = employeeService.findByIdAndDepts(id);
        //{"employee":{}, "depts":[{},{}] }
        model.addAttribute("employee", result.get("employee"));
        model.addAttribute("depts", result.get("depts"));
        return "emp-edit";
    }

    @RequestMapping("/save")
    public String save(Employee employee){
        log.info("employee:{}", employee);
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping("/saveUI")
    public String saveUI(Model model){
        log.info("saveUI----------------->");
        List<Department> departments = departmentService.findAll();
        model.addAttribute("depts", departments);
        return "emp-save";
    }


    @RequestMapping("/delete/{id}")
    @ResponseBody
    public ResultVO deleteById(@PathVariable("id") Long id){
        log.info("id:{}", id);
        employeeService.deleteById(id);
        return ResultVO.ok("delete success");
    }



    @RequestMapping("/list")
    public ModelAndView findAll(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "6")Integer pageSize){
        log.info("findAll------------------>");
        ModelAndView mav = new ModelAndView("emp-list");
        System.out.println("mav = " + mav);
        PageInfo<Employee> pageInfo = employeeService.findAllAndDept(pageNum, pageSize);
        mav.addObject("pageInfo", pageInfo);
        return mav;
    }


}
