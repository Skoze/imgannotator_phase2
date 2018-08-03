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
import wnderful.imgannotator.publicData.reponseCode.markResponseCode.CompleteImgRepCode;
import wnderful.imgannotator.publicData.response.MarkResponse.CompleteImgRep;
import wnderful.imgannotator.publicData.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CompleteImgTest {
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
        taskService1.releaseTask("caizhe", "aTask", "it is a aTask.",
                1, new String[]{"tag"}, 10, 10);
        taskService1.releaseTask("caizhe", "cat", "it is a cat.",
                1, new String[]{}, 100, 1);
        taskService1.receiptTask("caidixi", "aTask");
        taskService1.receiptTask("caidixi", "cat");
        taskService1.receiptTask("caiweilin", "aTask");
        taskService1.deleteTask("caizhe","cat");

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
        MarkServiceImpl markService = new MarkServiceImpl();
        markService.setMark("caidixi", "aTask", "124AF2A09B63B97FC94CF0D914992CA0.jpg", jsonObject);
    }

    @Test
    public void test1() {
        Response response = markService.completeImg("caididi", "aTask", "timg.jpg");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new CompleteImgRep(CompleteImgRepCode.NOTFOUND));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test2() {
        Response response = markService.completeImg("caiweilin", "cat", "timg.jpg");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new CompleteImgRep(CompleteImgRepCode.NOTASK));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test3() {
        Response response = markService.completeImg("caiweilin", "a", "timg.jpg");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new CompleteImgRep(CompleteImgRepCode.NOTASK));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test4() {
        Response response = markService.completeImg("caidixi", "cat", "timg.jpg");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new CompleteImgRep(CompleteImgRepCode.END));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test5() {
        Response response = markService.completeImg("caidixi", "aTask", "timg.jpg");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new CompleteImgRep(CompleteImgRepCode.NOMARK));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test6() {
        Response response = markService.completeImg("caidixi", "aTask", "123.jpg");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new CompleteImgRep(CompleteImgRepCode.NOIMG));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test7() {
        Response response = markService.completeImg("caidixi", "aTask", "124AF2A09B63B97FC94CF0D914992CA0.jpg");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new CompleteImgRep(CompleteImgRepCode.SUCCESS));
        assertEquals(hopeRep, repStr);
    }

    @Test
    public void test8() {
        Response response = markService.completeImg("caidixi", "aTask", "124AF2A09B63B97FC94CF0D914992CA0.jpg");
        String repStr = JSON.toJSONString(response);
        String hopeRep = JSON.toJSONString(new CompleteImgRep(CompleteImgRepCode.COMPLETE));
        assertEquals(hopeRep, repStr);
    }
}
