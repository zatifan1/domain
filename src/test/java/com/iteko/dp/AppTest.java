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

    @NotNull
    private ManagerClient managerClient;

    @NotNull
    private final UserDTO userDTO = new UserDTO();

//    @Before
//    public void setup() {
//        authClient = AuthResourceClient.getAuthInstance("http://localhost:8080/api");
//        Response response = authClient.auth("login", "1234");
//        Map<String, Collection<String>> headers1 = response.headers();
//        Collection<String> strings = headers1.get("Set-cookie");
//        Optional<String> first = strings.stream().findFirst();
//        String cookie = first.orElse("");
//        System.out.println("Cookie: " + cookie);
//    }


    @Test
    public void getAllUser() {
        authClient = AuthResourceClient.getAuthInstance("http://localhost:8080/api");
        userClient = AuthResourceClient.getUserInstance("http://localhost:8080/api");
        Response response = authClient.auth("login", "1234");
        Collection<String> strings = response.headers().get("Set-Cookie");
        for (String string : strings) {
            System.out.println(string);
            List<UserDTO> userDTOS = userClient.findAll(string);
            System.out.println(userDTOS.get(0).getLogin());
            Assert.assertNotNull(userDTOS.get(0));
        }
        System.out.println("Cookie: " + response);
    }


//    @Test
//    public void getUserById() {
//        @NotNull final UserDTO userDTO = userDTOClient.findById("client_id");
//        Assert.assertEquals(userDTO.getLogin(), "login");
//    }
//
//    @Test
//    public void createUser() {
//        userDTOClient.merge(userDTO);
//        @Nullable final UserDTO newUserDTO = userDTOClient.findById(userDTO.getUuid());
//        if (newUserDTO != null) Assert.assertEquals(newUserDTO.getLogin(), "test");
//        else Assert.fail("UserDTO is null.");
//    }
//
//    @Test
//    public void removeUser() {
//        userDTOClient.remove(userDTO.getUuid());
//        @Nullable final UserDTO newUserDTO = userDTOClient.findById(userDTO.getUuid());
//        Assert.assertNull(newUserDTO);
//    }
//
//    @Test
//    public void removeAllUser() {
//        userDTOClient.removeAll();
//        @NotNull final List<UserDTO> userDTOS = userDTOClient.findAll("");
//        assertEquals(0, userDTOS.size());
//    }

}
