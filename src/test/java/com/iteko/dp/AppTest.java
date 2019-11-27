package com.iteko.dp;

import com.iteko.dp.domain.ControllerFeignClientBuilder;
import com.iteko.dp.domain.client.AuthClient;
import com.iteko.dp.domain.client.ManagerClient;
import com.iteko.dp.domain.client.UserClient;
import com.iteko.dp.domain.dto.ManagerDTO;
import com.iteko.dp.domain.dto.PersonDTO;
import com.iteko.dp.domain.dto.UserDTO;
import com.iteko.dp.domain.enumeration.RoleType;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(JUnit4.class)
public class AppTest {

    @Nullable
    private UserClient userClient;

    @Nullable
    private AuthClient authClient;

    @Nullable
    private ManagerClient managerClient;

    @Nullable
    private String cookie;

    @NotNull
    private final UserDTO userDTO = new UserDTO();

    @Before
    public void setup() {
        userClient = new ControllerFeignClientBuilder().getUserClient();
        authClient = new ControllerFeignClientBuilder().getAuthClient();
        managerClient = new ControllerFeignClientBuilder().getManagerClient();
        Response response = authClient.auth("login", "password");
        userDTO.setId(UUID.randomUUID().toString());
        userDTO.setLogin("test");
        userDTO.setPassword("test");
        userDTO.setRoles(Arrays.asList(RoleType.TEACHER, RoleType.ADMIN));
        Map<String, Collection<String>> headers = response.headers();
        Collection<String> strings = headers.get("Set-cookie");
        Optional<String> first = strings.stream().findFirst();
        cookie = first.orElse("");
    }


    @Test
    public void getAllUser() {
        @NotNull List<UserDTO> userDTOS = userClient.findAll(cookie);
        assertTrue(userDTOS.size() > 0);
        log.info("{}", userDTOS);
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setUserDTO(userDTOS.get(0));
        PersonDTO personDTO = new PersonDTO();
        personDTO.setUser(userDTOS.get(0));
        managerDTO.setPersonDTO(personDTO);
        Assert.assertEquals(managerDTO.getId(), managerClient.merge(cookie, managerDTO).getId());
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
