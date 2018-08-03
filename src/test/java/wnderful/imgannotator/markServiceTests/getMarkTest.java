package wnderful.imgannotator.markServiceTests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.MarkServiceImpl;
import wnderful.imgannotator.blserviceImpl.TaskServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.GetMarkRepCode;
import wnderful.imgannotator.publicData.response.MarkResponse.GetMarkRep;
import wnderful.imgannotator.publicData.response.Response;
import wnderful.imgannotator.vo.MarkVo.AMarkVo;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class getMarkTest {
    private MarkServiceImpl markService = new MarkServiceImpl();

    @BeforeClass
    public static void prepare() {
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
        BaseServiceImpl baseService = new BaseServiceImpl();
        baseService.signUp("caizhe", "654321", "caizhe@163.com", "requester");
        baseService.signUp("caidixi", "123456", "caidixi@163.com", "worker");
        baseService.signUp("caiweilin", "111111", "caiweilin@163.com", "worker");
        TaskServiceImpl taskService1 = new TaskServiceImpl();
        taskService1.releaseTask("caizhe", "aTask", "it is a task.",
                1, new String[]{"tag"}, 10, 10);
        taskService1.receiptTask("caidixi","aTask");
        taskService1.releaseTask("caizhe","cat","it is a task.",
                1,new String[]{},100,1);
        taskService1.receiptTask("caidixi","cat");
    }

    @Test
    public void test1() {
        JSONObject jsonObject = JSON.parseObject("{\n" +
                "    \"wholeDesc\": \"123\",\n" +
                "    \"rectMark\": [\n" +
                "      {\n" +
                "        \"info\": {\n" +
                "          \"left\": 1,\n" +
                "          \"top\": 1,\n" +
                "          \"width\": 1,\n" +
                "          \"height\": 1\n" +
                "        },\n" +
                "        \"description\": {\n" +
                "          \"time\": \"\",\n" +
                "          \"content\": \"\"\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"polyMark\": [\n" +
                "      {\n" +
                "        \"info\": {\n" +
                "          \"x\": [],\n" +
                "          \"y\": []\n" +
                "        },\n" +
                "        \"description\": {\n" +
                "          \"time\": \"\",\n" +
                "          \"content\": \"\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }");
        markService.setMark("caidixi", "aTask", "124AF2A09B63B97FC94CF0D914992CA0.jpg", jsonObject);
        Response response = markService.getMark("aTask", "124AF2A09B63B97FC94CF0D914992CA0.jpg", "caidixi");
        AMarkVo vo = new AMarkVo(JSON.parseObject("{\n" +
                "    \"wholeDesc\": \"123\",\n" +
                "    \"rectMark\": [\n" +
                "      {\n" +
                "        \"info\": {\n" +
                "          \"left\": 1,\n" +
                "          \"top\": 1,\n" +
                "          \"width\": 1,\n" +
                "          \"height\": 1\n" +
                "        },\n" +
                "        \"description\": {\n" +
                "          \"time\": \"\",\n" +
                "          \"content\": \"\"\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"polyMark\": [\n" +
                "      {\n" +
                "        \"info\": {\n" +
                "          \"x\": [],\n" +
                "          \"y\": []\n" +
                "        },\n" +
                "        \"description\": {\n" +
                "          \"time\": \"\",\n" +
                "          \"content\": \"\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }"));
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetMarkRep(GetMarkRepCode.SUCCESS,vo));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test2(){
        Response response = markService.getMark("aTask","124AF2A09B63B97FC94CF0D914992CA0.jpg","caididi");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetMarkRep(GetMarkRepCode.NOTFOUND));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test3(){
        Response response = markService.getMark("Task","124AF2A09B63B97FC94CF0D914992CA0.jpg","caidixi");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetMarkRep(GetMarkRepCode.NOTASK));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test4(){
        Response response = markService.getMark("aTask","124AF2A09B63B97FC94CF0D914992CA0.jpg","caiweilin");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetMarkRep(GetMarkRepCode.NOTASK));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test5(){
        TaskServiceImpl taskService = new TaskServiceImpl();
        taskService.deleteTask("caizhe","cat");
        Response response = markService.getMark("cat","timg.jpg","caidixi");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetMarkRep(GetMarkRepCode.END));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test6(){
        Response response = markService.getMark("aTask","a.jpg","caidixi");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetMarkRep(GetMarkRepCode.NOIMG));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test7(){
        markService.completeImg("caidixi","aTask","124AF2A09B63B97FC94CF0D914992CA0.jpg");
        Response response = markService.getMark("aTask","124AF2A09B63B97FC94CF0D914992CA0.jpg","caidixi");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetMarkRep(GetMarkRepCode.COMPLETE));
        assertEquals(hopeRep,repStr);
    }

    @Test
    public void test8(){
        Response response = markService.getMark("aTask","timg.jpg","caidixi");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new GetMarkRep(GetMarkRepCode.NOMARK));
        assertEquals(hopeRep,repStr);
    }

}
