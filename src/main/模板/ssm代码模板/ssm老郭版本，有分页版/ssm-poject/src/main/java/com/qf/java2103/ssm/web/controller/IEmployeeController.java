package com.qf.java2103.ssm.web.controller;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/15
 */

import com.github.pagehelper.PageInfo;
import com.qf.java2103.ssm.pojo.Department;
import com.qf.java2103.ssm.pojo.Employee;
import com.qf.java2103.ssm.resultVO.ResultVO;
import com.qf.java2103.ssm.service.IDepartmentService;
import com.qf.java2103.ssm.service.impl.IEmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 员工控制层
 */
@Controller
@RequestMapping("/employee")
public class IEmployeeController {
    @Autowired
    private ResultVO resultVO;
    @Autowired
    private IEmployeeServiceImpl employeeService;
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/list")
    public ModelAndView findAllEmployee(@RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                        @RequestParam(name = "pageSize",required = false,defaultValue = "5") Integer pageSize ){
        System.out.println("pageNum = " + pageNum);
         ModelAndView mav = new ModelAndView();
        PageInfo<Employee> employees = employeeService.findAllEmployeeAndDept(pageNum, pageSize);
        mav.addObject("pageInfo",employees);
        mav.setViewName("emp-list");
        return mav;
    }


    @RequestMapping("/delete/{id}")
    @ResponseBody
    public ResultVO deleteById(@PathVariable Integer id){
        System.out.println("id = " + id);
        Integer ret = employeeService.deleteById(id);
        if (ret>0){
            resultVO.setSuccess(true);
            resultVO.setMessage("success");
            return resultVO;
        }else {
            resultVO.setSuccess(false);
            resultVO.setMessage("false");
        }
        return resultVO;
    }

    @RequestMapping("/editUI/{id}")
    @ResponseBody
    public ModelAndView showEmployee(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Employee employee = employeeService.findEmployeeById(id);
        List<Department> departments = departmentService.findAllDepartment();
        modelAndView.addObject("depts",departments);
        modelAndView.addObject("employee",employee);
        modelAndView.setViewName("emp-edit");
        return modelAndView;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public ModelAndView updateEmployee(Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        Integer integer = employeeService.updateEmployee(employee);
        if (integer>0){
            modelAndView.setViewName("forward:/employee/list");
        }else {
            modelAndView.setViewName("forward:/ssm_poject/employee/editUI/"+employee.getId());
        }
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("/saveUI")
    public ModelAndView showSave(){
        ModelAndView modelAndView = new ModelAndView();
        List<Department> departments = departmentService.findAllDepartment();
        modelAndView.addObject("depts",departments);
        modelAndView.setViewName("emp-save");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/save")
    public ModelAndView saveEmployee(Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        Integer row = employeeService.insertEmployee(employee);
        if (row>0){
            modelAndView.setViewName("forward:/employee/list");
        }
        return modelAndView;
    }





}
