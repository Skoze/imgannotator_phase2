package wnderful.imgannotator.userServiceTests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wnderful.imgannotator.blserviceImpl.BaseServiceImpl;
import wnderful.imgannotator.blserviceImpl.UserServiceImpl;
import wnderful.imgannotator.dataServiceImpl.NormalDataServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class GetRequesterMessageTest {
    private BaseServiceImpl baseService = new BaseServiceImpl();
    private UserServiceImpl userService = new UserServiceImpl();

    @BeforeClass
    public static void prepare(){
        NormalDataServiceImpl normalDataService = new NormalDataServiceImpl();
        normalDataService.deleteAll();
    }
    @Before
    public void signUp(){
        baseService.signUp("caidixi","123456","caidixi@163.com","worker");
        baseService.signUp("caizhe","654321","caizhe@163.com","requester");
    }

}
