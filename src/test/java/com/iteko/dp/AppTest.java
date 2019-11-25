package com.iteko.dp;

import com.iteko.dp.client.AuthDTOClient;
import com.iteko.dp.client.UserDTOClient;
import com.iteko.dp.dto.UserDTO;
import com.iteko.dp.enumeration.Role;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(JUnit4.class)
public class AppTest {

    @Nullable
    private UserDTOClient userDTOClient;

    @Nullable
    private AuthDTOClient authDTOClient;

    @Nullable
    private Response response;

    @NotNull
    private final UserDTO userDTO = new UserDTO();

    @Before
    public void setup() {
        userDTOClient = new UserControllerFeignClientBuilder().getUserDTOClient();
        authDTOClient = new UserControllerFeignClientBuilder().getAuthDTOClient();
        response = authDTOClient.auth("login", "password");
        userDTO.setUuid(UUID.randomUUID().toString());
        userDTO.setLogin("test");
        userDTO.setPassword("test");
        userDTO.setRoles(Arrays.asList(Role.TEACHER, Role.ADMIN));
    }

//    @Test
//    public void auth() {
//        Response response1 = authDTOClient.auth("login", "password");
//        Map<String, Collection<String>> headers = response1.headers();
//        for (String s : headers.keySet()) {
//            System.out.println(s);
//        }
//    }

    @Test
    public void getAllUser() {
        Map<String, Collection<String>> headers = response.headers();
        Collection<String> strings = headers.get("Set-cookie");
        Optional<String> first = strings.stream().findFirst();
        String s = first.orElse("");
        @NotNull List<UserDTO> userDTOS = userDTOClient.findAll(s);
        assertTrue(userDTOS.size() > 0);
        log.info("{}", userDTOS);
    }

    @Test
    public void getUserById() {
        @NotNull final UserDTO userDTO = userDTOClient.findById("client_id");
        Assert.assertEquals(userDTO.getLogin(), "login");
    }

    @Test
    public void createUser() {
        userDTOClient.merge(userDTO);
        @Nullable final UserDTO newUserDTO = userDTOClient.findById(userDTO.getUuid());
        if (newUserDTO != null) Assert.assertEquals(newUserDTO.getLogin(), "test");
        else Assert.fail("UserDTO is null.");
    }

    @Test
    public void removeUser() {
        userDTOClient.remove(userDTO.getUuid());
        @Nullable final UserDTO newUserDTO = userDTOClient.findById(userDTO.getUuid());
        Assert.assertNull(newUserDTO);
    }

    @Test
    public void removeAllUser() {
        userDTOClient.removeAll();
        @NotNull final List<UserDTO> userDTOS = userDTOClient.findAll("");
        assertEquals(0, userDTOS.size());
    }

}
