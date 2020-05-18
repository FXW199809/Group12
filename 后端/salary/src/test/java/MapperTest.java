import com.group12.salary.controller.ExamineController;
import com.group12.salary.controller.ExportController;
import com.group12.salary.controller.GetStaffController;
import com.group12.salary.model.ErrorDAO;
import com.group12.salary.model.SalaryDAO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MapperTest {

    @Test
    public static void main(String[] args) throws IOException, IllegalAccessException {

        /*
        //查找员工测试
        GetStaffController getStaffController = new GetStaffController();

        SalaryDAO salaryDAO = getStaffController.getStaffSearch("20140101");
        //System.out.println(13143412);
        System.out.println(salaryDAO.getName());*/

        /*//审批列表测试
        GetStaffController getStaffController = new GetStaffController();
        List<SalaryDAO> salaryDAOList = getStaffController.getSalaryList(true);

        //循环打印
        for(int i = 0; i < salaryDAOList.size(); i++){
            System.out.println(salaryDAOList.get(i).getName());
        }*/

        /*//批准驳回操作测试
        ExamineController examineController = new ExamineController();
        examineController.updateSalaryStatus(11,true);*/

        /*//汇总员工工资查看
        GetStaffController getStaffController = new GetStaffController();
        List<SalaryDAO> salaryDAOList = getStaffController.getStaffGather();
        for(int i = 0; i < salaryDAOList.size(); i++){
            System.out.println(salaryDAOList.get(i).getName());
        }*/

        //汇总导出工资excel
        ExportController exportController = new ExportController();
        exportController.exportSalaryManager("myexport", "F:/");
    }


}
