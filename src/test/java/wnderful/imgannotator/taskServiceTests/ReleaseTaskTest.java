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
import wnderful.imgannotator.publicData.reponseCode.taskResponseCode.ReleaseTaskRepCode;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.publicData.response.taskResponse.ReleaseTaskRep;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ReleaseTaskTest {
    private TaskServiceImpl taskService = new TaskServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caizhe","654321","caizhe@163.com","requester");
    }

    @Test
    public void test1(){
        String[] tag = new String[]{"tag"};
        Response response = taskService.releaseTask("caizhe","aTask","it is a task.",
                1,tag,10,10);
        String repStr = JSON.toJSONString(response);
        String hopeRes = JSON.toJSONString(new ReleaseTaskRep(ReleaseTaskRepCode.SUCCESS));
        assertEquals(hopeRes,repStr);
    }

    @Test
    public void test2(){
        Response response = taskService.releaseTask("caidixi","aTask","it is a task.",
                1,new String[]{"tag"},10,10);
        String repStr = JSON.toJSONString(response);
        String hopeRes = JSON.toJSONString(new ReleaseTaskRep(ReleaseTaskRepCode.NOTFOUND));
        assertEquals(hopeRes,repStr);
    }

    @Test
    public void test3(){
        Response response = taskService.releaseTask("caizhe","cat","it is a task.",
                1,new String[]{"tag"},100,10);
        String repStr = JSON.toJSONString(response);
        String hopeRes = JSON.toJSONString(new ReleaseTaskRep(ReleaseTaskRepCode.NOPOINT));
        assertEquals(hopeRes,repStr);
    }
    @Test
    public void test4(){
        Response response = taskService.releaseTask("caizhe","aTask","it is a task.",
                1,new String[]{"tag"},10,10);
        String repStr = JSON.toJSONString(response);
        String hopeRes = JSON.toJSONString(new ReleaseTaskRep(ReleaseTaskRepCode.REPEAT));
        assertEquals(hopeRes,repStr);
    }

    @Test
    public void test5(){
        Response response = taskService.releaseTask("caizhe","empty","it is a task.",
                1,new String[]{"tag"},10,10);
        String repStr = JSON.toJSONString(response);
        String hopeRes = JSON.toJSONString(new ReleaseTaskRep(ReleaseTaskRepCode.NOIMG));
        assertEquals(hopeRes,repStr);
    }

    @Test
    public void test6(){
        Response response = taskService.releaseTask("caizhe","cat","it is a task.",
                0,new String[]{},10,10);
        String repStr = JSON.toJSONString(response);
        String hopeRes = JSON.toJSONString(new ReleaseTaskRep(ReleaseTaskRepCode.WRONGDATA));
        assertEquals(hopeRes,repStr);
    }

    @Test
    public void test7(){
        Response response = taskService.releaseTask("caizhe","cat","it is a task.",
                1,new String[]{},10,0);
        String repStr = JSON.toJSONString(response);
        String hopeRes = JSON.toJSONString(new ReleaseTaskRep(ReleaseTaskRepCode.WRONGDATA));
        assertEquals(hopeRes,repStr);
    }

    @Test
    public void test8(){
        Response response = taskService.releaseTask("caizhe","cat","it is a task.",
                1,new String[]{},-1,10);
        String repStr = JSON.toJSONString(response);
        String hopeRes = JSON.toJSONString(new ReleaseTaskRep(ReleaseTaskRepCode.WRONGDATA));
        assertEquals(hopeRes,repStr);
    }
}
