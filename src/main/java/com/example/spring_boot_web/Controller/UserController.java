package com.example.spring_boot_web.Controller;

import com.example.spring_boot_web.dao.DepartmentDao;
import com.example.spring_boot_web.dao.EmployeeDao;
import com.example.spring_boot_web.entities.Department;
import com.example.spring_boot_web.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

/**
 * Create by czq
 * time on 2020/6/14  19:10
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private DepartmentDao departmentDao;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("user", username);
            return "redirect:/main";
        }
        map.put("msg", "用户名密码错误");
        return "login";
    }

    @GetMapping("/emps")
    public String getAllEmployees(Model model, HttpServletRequest request) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("employees", all);
        return "emp/list";
    }


    /**
     * 跳转到添加页面
     *
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String addEmployees(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departs", departments);
        return "emp/add";
    }

    /**
     * 进行添加人员的操作
     *
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmployeesTrue(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/user/emps";
    }


}
