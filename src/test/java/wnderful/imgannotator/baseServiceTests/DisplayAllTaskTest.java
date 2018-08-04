package wnderful.imgannotator.baseServiceTests;

import com.alibaba.fastjson.JSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.TaskServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.baseResponseCode.DisplayAllTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.baseResponse.DisplayAllTaskRep;
import wnderful.imgannotator.vo.taskVo.DisplayTaskVo;
import wnderful.imgannotator.vo.taskVo.TaskVo;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DisplayAllTaskTest {
    private BaseServiceImpl baseService = new BaseServiceImpl();
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
                1,new String[]{},500,2);
        taskService1.receiptTask("caidixi","aTask");
    }

    @Test
    public void test1(){
        Response response = baseService.displayAllTask();
        TaskVo taskVo1 = new TaskVo("aTask","picture/aTask/124AF2A09B63B97FC94CF0D914992CA0.jpg",1,new String[]{},1,2);
        TaskVo[] taskVos = new TaskVo[1];
        taskVos[0] = taskVo1;
        DisplayTaskVo displayTaskVo = new DisplayTaskVo(taskVos);

        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DisplayAllTaskRep(DisplayAllTaskRepCode.SUCCESS,displayTaskVo));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test2(){
        taskService.releaseTask("caojiawei","cat","it is a task.",
                1,new String[]{},100,10);
        Response response = baseService.displayAllTask();

        TaskVo taskVo1 = new TaskVo("aTask","picture/aTask/124AF2A09B63B97FC94CF0D914992CA0.jpg",1,new String[]{},1,2);
        TaskVo taskVo2 = new TaskVo("cat","picture/cat/timg.jpg",1,new String[]{},0,10);
        TaskVo[] taskVos = new TaskVo[2];
        taskVos[0] = taskVo1;
        taskVos[1] = taskVo2;
        DisplayTaskVo displayTaskVo = new DisplayTaskVo(taskVos);

        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new DisplayAllTaskRep(DisplayAllTaskRepCode.SUCCESS,displayTaskVo));
        assertEquals(hopeRep,repStr);
    }
}
