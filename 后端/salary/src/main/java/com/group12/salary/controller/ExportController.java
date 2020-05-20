package com.group12.salary.controller;

import com.group12.salary.config.ExcelUtil;
import com.group12.salary.model.SalaryDAO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 导出功能实现
 */

@RestController
public class ExportController {

    private static ExcelUtil excelUtil = new ExcelUtil();
    private static GetStaffController getStaffController = new GetStaffController();
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/exportSalaryManager")
    @RequiresRoles("财务管理员")//财务管理员角色
    public boolean exportSalaryManager(String fileName, String filePath) throws IOException {

        List<SalaryDAO> salaryDAOList = getStaffController.getStaffGather();
        List<Map<String, Object>> list_map = new ArrayList<Map<String, Object>>(); // 定义List<Map<String, Object>>数组<br>　　　　　　　　　　// list为外部传进来的list集合
        //System.out.println("mcerbv" + CollectionUtils.isEmpty(salaryDAOList));


        //将List<Salary>转换成List<Map<String,Object>
        if (!CollectionUtils.isEmpty(salaryDAOList)) {
            salaryDAOList.forEach(item ->{//<br>// PropertyUtils.describe(Object)转换
                Map<String, Object> map = null;
                try {
                    map = (Map<String, Object>) PropertyUtils.describe(item);
                    System.out.println(map);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                list_map.add(map);
                String[] title = "职工号,姓名,基本工资,职务工资,工龄工资,副食补贴,煤油补贴,交通补贴,备补1,备补2,应发工资,房费,水电费,托儿费,借支扣款,其他扣款,扣款总计,实发工资,时间".split(",");
                String[] column = "userId,name,baseSalary,jobSalary,workingAgeSalary,food,coal,transport,subsidy1,subsidy2,sumSalary,room,waterElectric,children,advance,other,deductTotal,takeHomeSalary,yearMonthDate".split(",");
                //List<Map> data = getStaffController.getStaffGather();
                excelUtil.getOutputFile(title, column, list_map, fileName, filePath);
                //System.out.println("cuiwhvyuer222");
            });
        }

        return true;
    }
}


































































































































