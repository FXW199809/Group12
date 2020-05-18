package com.group12.salary.Application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.group12.salary.dao")//加上你项目的dao或service所在文件位置即可
@SpringBootApplication(scanBasePackages = "com.group12.salary")
public class MapperTest {
    /**
     *
     */
    public static void main(String[] args){
        SpringApplication.run(MapperTest.class, args);
        /*
        //查询员工工资测试
        GetStaffController getStaffController = new GetStaffController();

        SalaryDAO salaryDAO = getStaffController.getStaffSearch("20140101");
        //System.out.println(13143412);
        System.out.println(salaryDAO.getName());*/

        /*//获取工资列表
        GetStaffController getStaffController = new GetStaffController();
        List<SalaryDAO> salaryDAOList = getStaffController.getSalaryList(true);

        //循环输出
        for(int i = 0; i < salaryDAOList.size(); i++){
            System.out.println(salaryDAOList.get(i).getName());
        }*/

        /*//审核
        ExamineController examineController = new ExamineController();
        examineController.updateSalaryStatus(11,true);*/

        /*//获取所有工资
        GetStaffController getStaffController = new GetStaffController();
        List<SalaryDAO> salaryDAOList = getStaffController.getStaffGather();
        for(int i = 0; i < salaryDAOList.size(); i++){
            System.out.println(salaryDAOList.get(i).getName());
        }*/

        /*//导出excel
        ExportController exportController = new ExportController();
        exportController.exportSalaryManager("myexport", "C://Users/Administrator/Desktop/");*/


    }


}
