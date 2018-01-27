package per.wph.resultful;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import per.wph.App;
import per.wph.info.controller.UserInfoController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MockServletContext.class,App.class})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
@WebAppConfiguration
public class UserControllerTest extends MockMvcResultMatchers{
    private MockMvc mvc;

    @Before
    public void setup(){
        mvc = MockMvcBuilders.standaloneSetup(new UserInfoController()).build();
    }

    @Test
    public void testUserInfoController() throws Exception {
        RequestBuilder request = null;
        request = MockMvcRequestBuilders.get("/permit/user/get?id=1");
        String response = mvc.perform(request).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(response);

        request = MockMvcRequestBuilders.post("/permit/getAll");
    }
}
