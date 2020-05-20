package com.group12.salary.Application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@MapperScan("com.group12.salary.dao")//加上你项目的dao或service所在文件位置即可
@SpringBootApplication(scanBasePackages = "com.group12.salary")
@ComponentScan("com.group12.salary.controller")
public class MapperTest {
    /**
     *
     */
    public static void main(String[] args) throws IOException {
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

        //获取所有工资
        //MDC.clear();
        /*GetStaffController getStaffController = new GetStaffController();
        List<SalaryDAO> salaryDAOList = getStaffController.getStaffGather();
        for(int i = 0; i < salaryDAOList.size(); i++){
            System.out.println(salaryDAOList.get(i).getName());
        }
        System.out.println(MapperTest.class);
        Logger logger = Logger.getLogger(MapperTest.class);
        //{table_name}','%X{column_name}','%X{change_id}',
        //'%X{before_value}','%X{after_value}','%X{user_id}'
        MDC.put("name", "t_tery");
        MDC.put("column_name", "weqr");
        MDC.put("change_id", "12");
        MDC.put("before_value", "123432");
        MDC.put("after_value", "22323");
        MDC.put("user_id", "4121");
        MDC.put("operation_type", "1");

        //logger.warning("warning");
        //PropertyConfigurator.configure("src/main/resources/log4j.properties");
        //System.out.println(MDC.get("table_name"));
        System.out.println(MDC.get("table_name"));
        //用来驱动，保存MDC里面的数据
        logger.info("获取员工汇总信息");
        System.out.println(MDC.get("table_name"));*/
        //logger.info(getStaffController);
        /*//导出excel
        ExportController exportController = new ExportController();
        exportController.exportSalaryManager("myexport", "C://Users/Administrator/Desktop/");*/


    }




}
