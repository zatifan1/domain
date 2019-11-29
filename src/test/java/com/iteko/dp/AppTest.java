package com.iteko.dp;

import com.iteco.dp.domain.AuthResourceClient;
import com.iteco.dp.domain.client.AuthClient;
import com.iteco.dp.domain.client.ManagerClient;
import com.iteco.dp.domain.client.UserClient;
import com.iteco.dp.domain.dto.UserDTO;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Collection;
import java.util.List;

@Slf4j
@RunWith(JUnit4.class)
public class AppTest {

    @NotNull
    private UserClient userClient;

    @NotNull
    private AuthClient authClient;

    @Test
    public void getAllUser() {
        authClient = AuthResourceClient.getAuthInstance("http://localhost:8080/api");
        userClient = AuthResourceClient.getUserInstance("http://localhost:8080/api");
        Response response = authClient.auth("admin", "admin");
        Collection<String> strings = response.headers().get("Set-Cookie");
        String cookie = "";
        for (String string : strings) {
            cookie = string;
        }
        System.out.println(cookie);
        List<UserDTO> userDTOS = userClient.findAll(cookie);
        System.out.println(userDTOS.get(0).getLogin());
        Assert.assertNotNull(userDTOS.get(0));
        System.out.println("Cookie: " + response);
    }

}
