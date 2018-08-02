package wnderful.imgannotator.TaskServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.TaskServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.DisplayReleasedTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.taskResponse.DisplayReleasedTaskRep;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;
import wnderful.imgannotator.vo.taskVo.TaskVo;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DisplayReleasedTaskTest {
    private TaskServiceImpl taskService = new TaskServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caizhe","654321","caizhe@163.com","requester");
        baseService.signUp("caojiawei","666666","caojiawei@163.com","requester");
        baseService.signUp("caidixi","123456","caidixi@163.com","worker");
        TaskServiceImpl taskService1 = new TaskServiceImpl();
        taskService1.releaseTask("caizhe","aTask","it is a task.",
                1,new String[]{"tag"},10,10);
        taskService1.releaseTask("caizhe","cat","it is a task.",
                1,new String[]{},100,1);
        taskService1.receiptTask("caidixi","cat");
    }

    @Test
    public void test1(){
        Response response = taskService.displayReleasedTask("caizhe");
        TaskVo taskVo1 = new TaskVo("aTask","picture/aTask/124AF2A09B63B97FC94CF0D914992CA0.jpg",1,new String[]{"tag"},0,10);
        TaskVo taskVo2 = new TaskVo("cat","picture/cat/timg.jpg",1,new String[]{},1,1);
        TaskVo[] taskVos = new TaskVo[2];
        taskVos[0] = taskVo1;
        taskVos[1] = taskVo2;
        DisplayTaskVo displayTaskVo = new DisplayTaskVo(taskVos);

        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.SUCCESS,displayTaskVo));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test2(){
        Response response = taskService.displayReleasedTask("caojiawei");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.NOTASK));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test3(){
        Response response = taskService.displayReleasedTask("caidixi");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.NOTFOUND));
        assertEquals(hopeRep,repStr);
    }
    @Test
    public void test4(){
        Response response = taskService.displayReleasedTask("cai");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DisplayReleasedTaskRep(DisplayReleasedTaskRepCode.NOTFOUND));
        assertEquals(hopeRep,repStr);
    }

}
