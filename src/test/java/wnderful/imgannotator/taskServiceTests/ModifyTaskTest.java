package wnderful.imgannotator.taskServiceTests;


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
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.ModifyTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.taskResponse.ModifyTaskRep;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ModifyTaskTest {
    private TaskServiceImpl taskService = new TaskServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caizhe","654321","caizhe@163.com","requester");
        baseService.signUp("caojiawei","666666","caojiawei@163.com","requester");
        TaskServiceImpl taskService1 = new TaskServiceImpl();
        taskService1.releaseTask("caizhe","aTask","it is a task.",
                1,new String[]{},10,10);
        taskService1.releaseTask("caojiawei","cat","it is a task.",
                1,new String[]{},100,1);
    }

    @Test
    public void test1(){
        Response response = taskService.modifyTask("caizhe","aTask","new description",
                2,new String[]{"tag"},12);
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ModifyTaskRep(ModifyTaskRepCode.SUCCESS));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test2(){
        Response response = taskService.modifyTask("caizh","aTask","new description",
                2,new String[]{"tag"},12);
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ModifyTaskRep(ModifyTaskRepCode.NOTFOUND));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test3(){
        Response response = taskService.modifyTask("caizhe","Task","new description",
                2,new String[]{"tag"},12);
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ModifyTaskRep(ModifyTaskRepCode.NOTASK));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test4(){
        Response response = taskService.modifyTask("caizhe","cat","new description",
                2,new String[]{"tag"},12);
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ModifyTaskRep(ModifyTaskRepCode.NORIGHT));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test5(){
        Response response = taskService.modifyTask("caizhe","aTask","new description",
                0,new String[]{"tag"},12);
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ModifyTaskRep(ModifyTaskRepCode.WRONGTIME));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test6(){
        Response response = taskService.modifyTask("caizhe","aTask","new description",
                2,new String[]{"tag"},5);
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ModifyTaskRep(ModifyTaskRepCode.WRONGMAXWORKER));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test7(){
        Response response = taskService.modifyTask("caojiawei","cat","new description",
                2,new String[]{"tag"},20);
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ModifyTaskRep(ModifyTaskRepCode.NOPOINTS));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test8(){
        Response response = taskService.modifyTask("caojiawei","cat","new description",
                2,new String[]{"tag"},10);
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new ModifyTaskRep(ModifyTaskRepCode.SUCCESS));
        assertEquals(hopeRep,repStr);
    }
}
